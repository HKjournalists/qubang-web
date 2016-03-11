/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.mtech.common.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.google.common.collect.Lists;
import com.mtech.common.entity.AbstractEntity;
import com.mtech.common.entity.search.Searchable;
import com.mtech.common.repository.BaseRepository;
import com.mtech.common.service.BaseService;

/**
 * <p>抽象service层基类 提供一些简便方法
 * <p/>
 * <p>泛型 ： M 表示实体类型；ID表示主键类型
 * <p/>
 * <p>User: Kaitao
 * <p>Date: 13-1-12 下午4:43
 * <p>Version: 1.0
 */
public abstract class AbstractBaseService<M extends AbstractEntity, ID extends Serializable> implements BaseService<M, ID> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
    protected BaseRepository<M, ID> baseRepository;

    /**
	 * 
	 * @param baseRepository 
	 * @see com.mtech.common.service.BaseService#setBaseRepository(com.mtech.common.repository.BaseRepository) 
	 */
    @Override
	@Autowired
    public void setBaseRepository(BaseRepository<M, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    /**
	 *  
	 * @param m
	 * @return 
	 * @see com.mtech.common.service.BaseService#save(M) 
	 */
    @Override
	public M save(M m) {
        return baseRepository.save(m);
    }

    /**
	 *  
	 * @param m
	 * @return 
	 * @see com.mtech.common.service.BaseService#saveAndFlush(M) 
	 */
    @Override
	public M saveAndFlush(M m) {
        m = save(m);
        baseRepository.flush();
        return m;
    }

    /**
	 *  
	 * @param m
	 * @return 
	 * @see com.mtech.common.service.BaseService#update(M) 
	 */
    @Override
	public M update(M m) {
        return baseRepository.save(m);
    }

    /**
	 *  
	 * @param id 
	 * @see com.mtech.common.service.BaseService#delete(ID) 
	 */
    @Override
	public void delete(ID id) {
        baseRepository.delete(id);
    }

    /**
	 *  
	 * @param m 
	 * @see com.mtech.common.service.BaseService#delete(M) 
	 */
    @Override
	public void delete(M m) {
        baseRepository.delete(m);
    }

    /**
	 *  
	 * @param ids 
	 * @see com.mtech.common.service.BaseService#delete(ID[]) 
	 */
    @Override
	public void delete(ID[] ids) {
        baseRepository.delete(ids);
    }


    /**
	 *  
	 * @param id
	 * @return 
	 * @see com.mtech.common.service.BaseService#findOne(ID) 
	 */
    @Override
	public M findOne(ID id) {
        return baseRepository.findOne(id);
    }

    
    /**
	 *  
	 * @param id
	 * @return 
	 * @see com.mtech.common.service.BaseService#get(ID) 
	 */
    @Override
	public M get(ID id) {
        return baseRepository.findOne(id);
    }
    
    /**
	 *  
	 * @param id
	 * @return 
	 * @see com.mtech.common.service.BaseService#exists(ID) 
	 */
    @Override
	public boolean exists(ID id) {
        return baseRepository.exists(id);
    }

    /**
	 *  
	 * @return 
	 * @see com.mtech.common.service.BaseService#count() 
	 */
    @Override
	public long count() {
        return baseRepository.count();
    }

    /**
	 *  
	 * @return 
	 * @see com.mtech.common.service.BaseService#findAll() 
	 */
    @Override
	public List<M> findAll() {
        return baseRepository.findAll();
    }

    /**
	 *  
	 * @param sort
	 * @return 
	 * @see com.mtech.common.service.BaseService#findAll(org.springframework.data.domain.Sort) 
	 */
    @Override
	public List<M> findAll(Sort sort) {
        return baseRepository.findAll(sort);
    }

    /**
	 *  
	 * @param pageable
	 * @return 
	 * @see com.mtech.common.service.BaseService#findAll(org.springframework.data.domain.Pageable) 
	 */
    @Override
	public Page<M> findAll(Pageable pageable) {
        return baseRepository.findAll(pageable);
    }

    /**
	 *  
	 * @param searchable
	 * @return 
	 * @see com.mtech.common.service.BaseService#findAll(com.mtech.common.entity.search.Searchable) 
	 */
    @Override
	public Page<M> findAll(Searchable searchable) {
        return baseRepository.findAll(searchable);
    }

    /**
	 *  
	 * @param searchable
	 * @return 
	 * @see com.mtech.common.service.BaseService#findAllWithNoPageNoSort(com.mtech.common.entity.search.Searchable) 
	 */
    @Override
	public List<M> findAllWithNoPageNoSort(Searchable searchable) {
        searchable.removePageable();
        searchable.removeSort();
        return Lists.newArrayList(baseRepository.findAll(searchable).getContent());
    }

    /**
	 *  
	 * @param searchable
	 * @return 
	 * @see com.mtech.common.service.BaseService#findAllWithSort(com.mtech.common.entity.search.Searchable) 
	 */
    @Override
	public List<M> findAllWithSort(Searchable searchable) {
        searchable.removePageable();
        return Lists.newArrayList(baseRepository.findAll(searchable).getContent());
    }


    /**
	 *  
	 * @param searchable
	 * @return 
	 * @see com.mtech.common.service.BaseService#count(com.mtech.common.entity.search.Searchable) 
	 */
    @Override
	public Long count(Searchable searchable) {
        return baseRepository.count(searchable);
    }


}
