package com.mtech.scheduler.core.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mtech.scheduler.core.service.DubboUserService;
import com.mtech.scheduler.core.vo.User;

@Service
public class DubboUserServiceImpl implements DubboUserService{


	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return new User(id, UUID.randomUUID().toString());
	}

	
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return user;
	}

}
