package com.mtech.scheduler.core.service;

import com.mtech.scheduler.core.entity.App;

public interface DubboAppService {
	public App findByName(String name);
}
