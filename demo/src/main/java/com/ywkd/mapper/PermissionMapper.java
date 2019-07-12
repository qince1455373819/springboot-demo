package com.ywkd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PermissionMapper {
	List<String> findByRoleId(@Param("roleIds") List<Integer> roleIds);
}
