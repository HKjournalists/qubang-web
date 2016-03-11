package com.mtech.scheduler.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mtech.common.service.impl.AbstractBaseService;
import com.mtech.scheduler.core.entity.App;
import com.mtech.scheduler.core.repository.AppRepository;
import com.mtech.scheduler.core.service.AppService;
import com.mtech.uam.enumdata.AvailableStatus;

@Service("appServiceImpl")
public class AppServiceImpl extends AbstractBaseService<App, String> implements AppService{
	
	private AppRepository getSysAppRepository() {
        return (AppRepository) baseRepository;
    }

	/**
	 * TODO 
	 * @param app 
	 * @see com.ibm.uam.permission.service.AppService#createApp(com.ibm.uam.permission.entity.App) 
	 */
	@Override
	@CacheEvict(value="AppService.App",key="#app.getId()")
	public void createApp(App app){
		app.setAvailable(AvailableStatus.Valid.getCode());
		this.save(app);
	}
	/**
	 * TODO 
	 * @param app 
	 * @see com.ibm.uam.permission.service.AppService#updateApp(com.ibm.uam.permission.entity.App) 
	 */
	@Override
	@CacheEvict(value="AppService.App",key="#app.getId()")
	public void updateApp(App app){
		this.save(app);
	}
	
	@Cacheable(value="AppService.App" ,key="#appId")
	public App findOne(String appId){
		System.out.println(" findOne not find from cache");
		return getSysAppRepository().findOne(appId);
	}
	@Override
	@CacheEvict(value="AppService.App",key="#appId")
	public Map<String,Object> deleteApp(String appId){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			getSysAppRepository().delete(appId);
			map.put("success", true);
			map.put("msg","操作成功！");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("msg","操作失败，"+e.getMessage());
		}
		return map;
	}
	@Override
	public App findByName(String name) {
		if(name==null){
			return null;
		}
		List<App> apps = getSysAppRepository().findAppByName(name.trim());
		if(apps==null || apps.isEmpty()){
			return null;
		}else{
			return apps.get(0);
		}
	}
}
