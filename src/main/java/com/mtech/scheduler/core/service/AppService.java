package com.mtech.scheduler.core.service;

import java.util.Map;

import com.mtech.common.service.BaseService;
import com.mtech.scheduler.core.entity.App;

public interface AppService extends BaseService<App, String>{

	/**
	 * 新增app
	 * @param app
	 */
	public   void createApp(App app);

	/**
	 * 修改app
	 * @param app
	 */
	public   void updateApp(App app);
	
	
	public App findOne(String appId);
	
	public App findByName(String name);

	public Map<String, Object> deleteApp(String appId);

}