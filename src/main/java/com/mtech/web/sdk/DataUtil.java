package com.mtech.web.sdk;

import java.util.List;

import com.mtech.common.utils.SpringUtils;
import com.mtech.scheduler.core.entity.App;
import com.mtech.scheduler.core.service.AppService;

public class DataUtil {

	public static List<App> findAllApps(){
		AppService appService = SpringUtils.getBean(AppService.class);
		return appService.findAll();
	}
}
