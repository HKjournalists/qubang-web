/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.mtech.common.repository.support;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.LockMetadataProvider;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.mtech.common.entity.search.Searchable;
import com.mtech.common.exception.BusinessException;
import com.mtech.common.plugin.entity.LogicDeleteable;
import com.mtech.common.repository.BaseRepository;
import com.mtech.common.repository.RepositoryHelper;
import com.mtech.common.repository.callback.SearchCallback;
import com.mtech.common.repository.hibernate.filter.EntityFilter;
import com.mtech.common.repository.hibernate.filter.FilterQuery;
import com.mtech.common.repository.support.annotation.QueryJoin;
import com.mtech.common.utils.SpringUtils;

/**
 * <p>抽象基础Custom Repository 实现,继承这个类的实体一定需要实现LogicDeleteable逻辑删除，
 * 如果没有逻辑删除，可继承别的repository</p>
 * <p>User: Kaitao
 * <p>Date: 13-1-15 下午7:33
 * <p>Version: 1.0
 */
public class SimpleBaseRepository<M, ID extends Serializable> extends SimpleJpaRepository<M, ID>
        implements BaseRepository<M, ID> {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String LOGIC_DELETE_ALL_QUERY_STRING = "update %s x set x.isDeleted='1', x.updateDate = ?2, x.updateBy = ?3 where x.%s in (?1)";
    public static final String LOGIC_DELETE_QUERY_STRING = "update %s x set x.isDeleted='1', x.updateDate = ?2, x.updateBy = ?3 where x.%s in (?1)";
    public static final String DELETE_ALL_QUERY_STRING = "delete from %s x where x.%s in (?1)";
    public static final String FIND_QUERY_STRING = "from %s x where x.isDeleted='0' ";
    public static final String COUNT_QUERY_STRING = "select count(x) from %s x where x.isDeleted='0' ";

    private final EntityManager em;
    private final JpaEntityInformation<M, ID> entityInformation;

    private final RepositoryHelper repositoryHelper;

    private LockMetadataProvider lockMetadataProvider;

    private Class<M> entityClass;
    private String entityName;
    private String idName;
    private Class<?> springDataRepositoryInterface;

    /**
     * 查询所有的QL
     */
    private String findAllQL;
    /**
     * 统计QL
     */
    private String countAllQL;

    private QueryJoin[] joins;

    private SearchCallback searchCallback = SearchCallback.DEFAULT;
    
    public SimpleBaseRepository(JpaEntityInformation<M, ID> entityInformation, EntityManager entityManager, Class<?> springDataRepositoryInterface) {
        super(entityInformation, entityManager);

        this.entityInformation = entityInformation;
        this.entityClass = this.entityInformation.getJavaType();
        this.entityName = this.entityInformation.getEntityName();
        this.idName = this.entityInformation.getIdAttributeNames().iterator().next();
        this.em = entityManager;
        this.springDataRepositoryInterface = springDataRepositoryInterface;

        repositoryHelper = new RepositoryHelper(entityClass);

        findAllQL = String.format(FIND_QUERY_STRING, entityName);
        countAllQL = String.format(COUNT_QUERY_STRING, entityName);
    }


    /**
     * Configures a custom {@link org.springframework.data.jpa.repository.support.LockMetadataProvider} to be used to detect {@link javax.persistence.LockModeType}s to be applied to
     * queries.
     *
     * @param lockMetadataProvider
     */
    public void setLockMetadataProvider(LockMetadataProvider lockMetadataProvider) {
        super.setLockMetadataProvider(lockMetadataProvider);
        this.lockMetadataProvider = lockMetadataProvider;
    }

    /**
     * 设置searchCallback
     *
     * @param searchCallback
     */
    public void setSearchCallback(SearchCallback searchCallback) {
        this.searchCallback = searchCallback;
    }

    /**
     * 设置查询所有的ql
     *
     * @param findAllQL
     */
    public void setFindAllQL(String findAllQL) {
        this.findAllQL = findAllQL;
    }

    /**
     * 设置统计的ql
     *
     * @param countAllQL
     */
    public void setCountAllQL(String countAllQL) {
        this.countAllQL = countAllQL;
    }

    public void setJoins(QueryJoin[] joins) {
        this.joins = joins;
    }

    /////////////////////////////////////////////////
    ////////覆盖默认spring data jpa的实现////////////
    /////////////////////////////////////////////////

    /**
     * 根据主键删除相应实体
     *
     * @param id 主键
     */
    @Transactional
    @Override
    public void delete(final ID id) {
        M m = findOne(id);
        delete(m);
    }

    /**
     * 删除实体
     *
     * @param m 实体
     */
    @Transactional
    @Override
    public void delete(final M m) {
        if (m == null) {
            return;
        }
        if (m instanceof LogicDeleteable) {
        	try {
				String ql = String.format(LOGIC_DELETE_QUERY_STRING, entityName, idName);
				ID id = (ID) BeanUtils.getProperty(m, idName);
				repositoryHelper.batchUpdate(ql, id, new Date(), getCurrentAuditor());
			} catch (Exception e) {
				logger.error("逻辑删除失败",e);
				throw new BusinessException("逻辑删除失败", e);
			}
        } else {
            super.delete(m);
        }
    }


    /**
     * 根据主键删除相应实体
     *
     * @param ids 实体
     */
    @Transactional
    @Override
    public void delete(final ID[] ids) {
        if (ArrayUtils.isEmpty(ids)) {
            return;
        }
    	
    	List<ID> idList = new ArrayList<ID>();
    	for(ID id:ids){
    		idList.add(id);
    	}
    	
    	boolean logicDeleteableEntity = LogicDeleteable.class.isAssignableFrom(this.entityClass);
        
    	if (logicDeleteableEntity) {
            String ql = String.format(LOGIC_DELETE_ALL_QUERY_STRING, entityName, idName);
            repositoryHelper.batchUpdate(ql, idList, new Date(), getCurrentAuditor());
        } else {
            String ql = String.format(DELETE_ALL_QUERY_STRING, entityName, idName);
            repositoryHelper.batchUpdate(ql, idList);
        }
    }
    
    @SuppressWarnings({"unchecked" })
    private String getCurrentAuditor(){
    	AuditorAware<String> auditorAware = SpringUtils.getBean(AuditorAware.class);
    	if(auditorAware==null){
    		return "SYSTEM";
    	}else{
    		return auditorAware.getCurrentAuditor();
    	}
    }
    
    @Transactional
    @Override
    public void deleteInBatch(final Iterable<M> entities) {
        Iterator<M> iter = entities.iterator();
        if (entities == null || !iter.hasNext()) {
            return;
        }
        ID[] ids = null;
        while(iter.hasNext()){
        	try {
				ids = (ID[]) ArrayUtils.add(ids, BeanUtils.getProperty(iter.next(), idName));
			} catch (Exception e) {
				e.printStackTrace();
				
			}
        }
        delete(ids);
    }
    
    /**
     * 按照主键查询
     *
     * @param id 主键
     * @return 返回id对应的实体
     */
    @Transactional
    @Override
    public M findOne(ID id) {
        if (id == null) {
            return null;
        }
        if (id instanceof Integer && ((Integer) id).intValue() == 0) {
            return null;
        }
        if (id instanceof Long && ((Long) id).longValue() == 0L) {
            return null;
        }
        return super.findOne(id);
    }


    ////////根据Specification查询 直接从SimpleJpaRepository复制过来的///////////////////////////////////
    @Override
    public M findOne(Specification<M> spec) {
        try {
            return getQuery(spec, (Sort) null).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#findAll(ID[])
     */
    public List<M> findAll(Iterable<ID> ids) {

        return getQuery(new Specification<M>() {
            public Predicate toPredicate(Root<M> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<?> path = root.get(entityInformation.getIdAttribute());
                return path.in(cb.parameter(Iterable.class, "ids"));
            }
        }, (Sort) null).setParameter("ids", ids).getResultList();
    }


    /*
     * (non-Javadoc)
     * @see org.springframework.data.jpa.repository.JpaSpecificationExecutor#findAll(org.springframework.data.jpa.domain.Specification)
     */
    public List<M> findAll(Specification<M> spec) {
        return getQuery(spec, (Sort) null).getResultList();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.jpa.repository.JpaSpecificationExecutor#findAll(org.springframework.data.jpa.domain.Specification, org.springframework.data.domain.Pageable)
     */
    public Page<M> findAll(Specification<M> spec, Pageable pageable) {

        TypedQuery<M> query = getQuery(spec, pageable);
        return pageable == null ? new PageImpl<M>(query.getResultList()) : readPage(query, pageable, spec);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.jpa.repository.JpaSpecificationExecutor#findAll(org.springframework.data.jpa.domain.Specification, org.springframework.data.domain.Sort)
     */
    public List<M> findAll(Specification<M> spec, Sort sort) {

        return getQuery(spec, sort).getResultList();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.jpa.repository.JpaSpecificationExecutor#count(org.springframework.data.jpa.domain.Specification)
     */
    public long count(Specification<M> spec) {

        return getCountQuery(spec).getSingleResult();
    }
    ////////根据Specification查询 直接从SimpleJpaRepository复制过来的///////////////////////////////////


    ///////直接从SimpleJpaRepository复制过来的///////////////////////////////

    /**
     * Reads the given {@link javax.persistence.TypedQuery} into a {@link org.springframework.data.domain.Page} applying the given {@link org.springframework.data.domain.Pageable} and
     * {@link org.springframework.data.jpa.domain.Specification}.
     *
     * @param query    must not be {@literal null}.
     * @param spec     can be {@literal null}.
     * @param pageable can be {@literal null}.
     * @return
     */
    private Page<M> readPage(TypedQuery<M> query, Pageable pageable, Specification<M> spec) {

        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        Long total = QueryUtils.executeCountQuery(getCountQuery(spec));
        List<M> content = total > pageable.getOffset() ? query.getResultList() : Collections.<M>emptyList();

        return new PageImpl<M>(content, pageable, total);
    }

    /**
     * Creates a new count query for the given {@link org.springframework.data.jpa.domain.Specification}.
     *
     * @param spec can be {@literal null}.
     * @return
     */
    private TypedQuery<Long> getCountQuery(Specification<M> spec) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);


        Root<M> root = applySpecificationToCriteria(spec, query);

        if (query.isDistinct()) {
            query.select(builder.countDistinct(root));
        } else {
            query.select(builder.count(root));
        }

        TypedQuery<Long> q = em.createQuery(query);
        repositoryHelper.applyEnableQueryCache(q);
        return q;
    }

    /**
     * Creates a new {@link javax.persistence.TypedQuery} from the given {@link org.springframework.data.jpa.domain.Specification}.
     *
     * @param spec     can be {@literal null}.
     * @param pageable can be {@literal null}.
     * @return
     */
    private TypedQuery<M> getQuery(Specification<M> spec, Pageable pageable) {

        Sort sort = pageable == null ? null : pageable.getSort();
        return getQuery(spec, sort);
    }

    /**
     * Creates a {@link javax.persistence.TypedQuery} for the given {@link org.springframework.data.jpa.domain.Specification} and {@link org.springframework.data.domain.Sort}.
     *
     * @param spec can be {@literal null}.
     * @param sort can be {@literal null}.
     * @return
     */
    private TypedQuery<M> getQuery(Specification<M> spec, Sort sort) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<M> query = builder.createQuery(entityClass);
        

        Root<M> root = applySpecificationToCriteria(spec, query);
        
        query.select(root);

        applyJoins(root);

        if (sort != null) {
            query.orderBy(toOrders(sort, root, builder));
        }

        TypedQuery<M> q = em.createQuery(query);

        repositoryHelper.applyEnableQueryCache(q);

        return applyLockMode(q);
    }

    private void applyJoins(Root<M> root) {
        if(joins == null) {
            return;
        }

        for(QueryJoin join : joins) {
            root.join(join.property(), join.joinType());
        }
    }


    /**
     * Applies the given {@link org.springframework.data.jpa.domain.Specification} to the given {@link javax.persistence.criteria.CriteriaQuery}.
     *
     * @param spec  can be {@literal null}.
     * @param query must not be {@literal null}.
     * @return
     */
    private <S> Root<M> applySpecificationToCriteria(Specification<M> spec, CriteriaQuery<S> query) {

        Assert.notNull(query);
        Root<M> root = query.from(entityClass);

        if (spec == null) {
            return root;
        }

        CriteriaBuilder builder = em.getCriteriaBuilder();
        Predicate predicate = spec.toPredicate(root, query, builder);

        if (predicate != null) {
            query.where(predicate);
        }

        return root;
    }

    private TypedQuery<M> applyLockMode(TypedQuery<M> query) {
        LockModeType type = lockMetadataProvider == null ? null : lockMetadataProvider.getLockModeType();
        return type == null ? query : query.setLockMode(type);
    }
    ///////直接从SimpleJpaRepository复制过来的///////////////////////////////


    @Override
    public List<M> findAll() {
    	
        return repositoryHelper.findAll(findAllQL);
    }

    @Override
    public List<M> findAll(final Sort sort) {
        return repositoryHelper.findAll(findAllQL, sort);
    }

    @Override
    public Page<M> findAll(final Pageable pageable) {
        return new PageImpl<M>(
                repositoryHelper.<M>findAll(findAllQL, pageable),
                pageable,
                repositoryHelper.count(countAllQL)
        );
    }

    @Override
    public long count() {
        return repositoryHelper.count(countAllQL);
    }


    /////////////////////////////////////////////////
    ///////////////////自定义实现////////////////////
    /////////////////////////////////////////////////

    @Override
    public Page<M> findAll(final Searchable searchable) {
        List<M> list = repositoryHelper.findAll(findAllQL, searchable, searchCallback);
        long total = searchable.hasPageable() ? count(searchable) : list.size();
        return new PageImpl<M>(
                list,
                searchable.getPage(),
                total
        );
    }

    @Override
    public long count(final Searchable searchable) {
        return repositoryHelper.count(countAllQL, searchable, searchCallback);
    }

    /**
     * 重写默认的 这样可以走一级/二级缓存
     *
     * @param id
     * @return
     */
    @Override
    public boolean exists(ID id) {
        return findOne(id) != null;
    }
    
    @Override
    public void enableFilter(String filterName, Map<String, Object> filterParams){
    	if(filterName!=null){
    		Filter filter = em.unwrap(Session.class).enableFilter(
    				filterName);
    		if(filterParams!=null){
    			// set filter parameter
    			for (String filterParamName : filterParams.keySet()) {
    				Object filterParamValue = filterParams.get(filterParamName);
    				filter.setParameter(filterParamName, filterParamValue);
    			}
    		}
    	}
    }
    @Override
    public void disableFilter(String filterName){
    	if(filterName!=null){
    		em.unwrap(Session.class).disableFilter(filterName);
    	}
    }
    
    @Override
	public List<M> doQueryWithFilter(String filterName, String filterQueryName,	Map inFilterParams, Map inQueryParams) {
		if (BaseRepository.class.isAssignableFrom(springDataRepositoryInterface)) {
			Annotation entityFilterAnn = springDataRepositoryInterface
					.getAnnotation(EntityFilter.class);
			if (entityFilterAnn != null) {
				EntityFilter entityFilter = (EntityFilter) entityFilterAnn;
				FilterQuery[] filterQuerys = entityFilter.filterQueries();
				for (FilterQuery fQuery : filterQuerys) {
					if (StringUtils.equals(filterQueryName, fQuery.name())) {
						String jpql = fQuery.jpql();
						Filter filter = em.unwrap(Session.class).enableFilter(
								filterName);

						// set filter parameter
						for (Object key : inFilterParams.keySet()) {
							String filterParamName = key.toString();
							Object filterParamValue = inFilterParams.get(key);
							filter.setParameter(filterParamName,
									filterParamValue);
						}

						// set query parameter
						Query query = em.createQuery(jpql);
						for (Object key : inQueryParams.keySet()) {
							String queryParamName = key.toString();
							Object queryParamValue = inQueryParams.get(key);
							query.setParameter(queryParamName, queryParamValue);
						}
						return query.getResultList();
					}
				}
			}
		}
		return null;
	}


	@Override
	public EntityManager getEntityManager() {
		return em;
	}

}
