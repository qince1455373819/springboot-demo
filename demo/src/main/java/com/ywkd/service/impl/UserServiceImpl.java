package com.ywkd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywkd.mapper.UserMapper;
import com.ywkd.model.User;
import com.ywkd.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findByAccount(String account) {
		return userMapper.findByAccount(account);
	}
	
}
