package com.ywkd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywkd.mapper.PermissionMapper;
import com.ywkd.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    
	@Override
	public List<String> findByRoleId(List<Integer> roleIds) {
		return permissionMapper.findByRoleId(roleIds);
	}

}
