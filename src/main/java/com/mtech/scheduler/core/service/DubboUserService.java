package com.mtech.scheduler.core.service;

import com.mtech.scheduler.core.vo.User;


public interface DubboUserService {

	public User getUser(Long id);

	
	public User addUser(User user);
}
