package com.mtech.scheduler.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtech.scheduler.core.entity.App;
import com.mtech.scheduler.core.service.AppService;
import com.mtech.scheduler.core.service.DubboAppService;

@Service
public class DubboAppServiceImpl implements DubboAppService {

	@Autowired
	private AppService appService;
	
	@Override
	public App findByName(String name) {
		System.out.println("==================>>>"+name);
		App app = appService.findByName(name);
		return app;
	}

}
