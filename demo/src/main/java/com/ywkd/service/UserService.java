package com.ywkd.service;

import com.ywkd.model.User;

public interface UserService {
	public User findByAccount(String account);
}
