package com.alibaba.service;

import org.springframework.stereotype.Service;

import com.alibaba.entity.User;

@Service
public interface OrderService {

	void createOrder(double price, String type, String color, int number, String rear, String front, String capacity,
			User user, int goodsId);

}
