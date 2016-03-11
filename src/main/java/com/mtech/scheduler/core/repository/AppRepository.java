package com.mtech.scheduler.core.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.mtech.common.repository.BaseRepository;
import com.mtech.scheduler.core.entity.App;

public interface AppRepository extends BaseRepository<App, String>{
	
	@Query("from App WHERE    isDeleted = '0'")
	public List<App> findAllApp();
	
	@Query("from App a where a.appName=? and a.isDeleted='0'")
	public List<App> findAppByName(String name);
	
}
