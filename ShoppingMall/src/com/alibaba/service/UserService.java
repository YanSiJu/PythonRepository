package com.alibaba.service;

import org.springframework.stereotype.Service;

import com.alibaba.entity.User;

@Service
public interface UserService {

	public User login(String userName, String pwd);

	public void register(User user);
}
