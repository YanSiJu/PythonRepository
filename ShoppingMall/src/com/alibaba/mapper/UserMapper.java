package com.alibaba.mapper;

import org.springframework.stereotype.Repository;

import com.alibaba.entity.User;

@Repository
public interface UserMapper {

	public User selectUserByName(String userName);

	public void insertUser(User user);

}
