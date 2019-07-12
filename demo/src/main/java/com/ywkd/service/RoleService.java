package com.ywkd.service;

import java.util.List;

import com.ywkd.model.Role;

public interface RoleService {
	public List<Role> findRoleByUserId(Integer id);
}
