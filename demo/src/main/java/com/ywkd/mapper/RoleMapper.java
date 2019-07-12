package com.ywkd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ywkd.model.Role;

@Mapper
@Repository
public interface RoleMapper {
    List<Role> findRoleByUserId(@Param("userId") Integer userId);
}
