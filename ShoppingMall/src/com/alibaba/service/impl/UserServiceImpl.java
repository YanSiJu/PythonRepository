package com.alibaba.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.entity.ShoppingTrolley;
import com.alibaba.entity.User;
import com.alibaba.mapper.ShoppingTrolleyMapper;
import com.alibaba.mapper.UserMapper;
import com.alibaba.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private ShoppingTrolleyMapper trolleyMapper;

	public User login(String userName, String pwd) {

		User user = mapper.selectUserByName(userName);
		System.out.println("login:" + user);
		if (user != null && BCrypt.checkpw(pwd, user.getPassword())) {
			return user;
		}
		return null;
	}

	public boolean validateUserName(String userName) {
		if (mapper.selectUserByName(userName) != null) {
			return true;// 用户名已被注册
		}
		return false;// 用户名未被注册
	}

	public void register(User user) {
		System.out.println(user);
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		mapper.insertUser(user);
		User u = mapper.selectUserByName(user.getUserName());
		ShoppingTrolley trolley = new ShoppingTrolley(1, u.getId());
		// 创建购物车
		trolleyMapper.createShoppingTrolley(trolley);
	}
}
