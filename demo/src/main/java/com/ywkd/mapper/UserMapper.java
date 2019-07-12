package com.ywkd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ywkd.model.User;

@Mapper
@Repository
public interface UserMapper {
	User findByAccount(@Param("account") String account);
}
