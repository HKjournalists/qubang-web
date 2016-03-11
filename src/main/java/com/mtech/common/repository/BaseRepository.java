/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.mtech.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.mtech.common.entity.search.Searchable;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

/**
 * <p>抽象DAO层基类 提供一些简便方法<br/>
 * 具体使用请参考测试用例：{@see com.mtech.common.repository.UserRepository}
 * <p/>
 * 想要使用该接口需要在spring配置文件的jpa:repositories中添加
 * factory-class="com.mtech.common.repository.support.SimpleBaseRepositoryFactoryBean"
 * <p/>
 * <p>泛型 ： M 表示实体类型；ID表示主键类型
 * <p>User: Kaitao
 * <p>Date: 13-1-12 下午4:46
 * <p>Version: 1.0
 */
@NoRepositoryBean
public interface BaseRepository<M, ID extends Serializable> extends JpaRepository<M, ID> {

    /**
     * 根据主键删除
     *
     * @param ids
     */
    public void delete(ID[] ids);

    /*
   * (non-Javadoc)
   * @see org.springframework.data.repository.CrudRepository#findAll()
   */
    List<M> findAll();

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Sort)
     */
    List<M> findAll(Sort sort);


    /**
     * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
     *
     * @param pageable
     * @return a page of entities
     */
    Page<M> findAll(Pageable pageable);

    /**
     * 根据条件查询所有
     * 条件 + 分页 + 排序
     *
     * @param searchable
     * @return
     */
    public Page<M> findAll(Searchable searchable);


    /**
     * 根据条件统计所有记录数
     *
     * @param searchable
     * @return
     */
    public long count(Searchable searchable);
    
    /**
     * 
     * 使用Filter进行查询
     * @since 2014年12月18日
     * @param filterName
     * @param filterQueryName
     * @param inFilterParams
     * @param inQueryParams
     * @return 
     * @return List<M>    返回类型
     */
    public List<M> doQueryWithFilter(String filterName, String filterQueryName,	Map inFilterParams, Map inQueryParams);
    
    /**
     * 
     * 启动Hibernate Filter
     * @since 2014年12月20日
     * @param filterName
     * @param filterParams 
     * @return void    返回类型
     */
    public void enableFilter(String filterName, Map<String, Object> filterParams);
    
    /**
     * 
     * 禁用Hibernate Filter
     * @since 2014年12月20日
     * @param filterName
     * @param filterParams 
     * @return void    返回类型
     */
    public void disableFilter(String filterName);
    
    /**
     * 获取EntityManager
     * @return
     */
    public EntityManager getEntityManager(); 
}
