package com.ywkd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywkd.mapper.RoleMapper;
import com.ywkd.model.Role;
import com.ywkd.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {
    
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> findRoleByUserId(Integer id) {
		return roleMapper.findRoleByUserId(id);
	}

}
