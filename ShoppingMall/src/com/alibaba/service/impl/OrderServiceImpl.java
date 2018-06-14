package com.alibaba.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.entity.GoodsInOrder;
import com.alibaba.entity.Order;
import com.alibaba.entity.User;
import com.alibaba.mapper.GoodsMapper;
import com.alibaba.mapper.OrderMapper;
import com.alibaba.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper mapper;

	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public void createOrder(double price, String type, String color, int number, String rear, String front,
			String capacity, User user, int goodsId) {

		String name = null;
		String address = null;
		int userId = 0;
		if (user != null) {
			name = user.getName();
			address = user.getAddress();
			userId = user.getId();
		}

		DateTimeFormatter dateTimeformatter = DateTimeFormatter.ofPattern("YYYYMMddHHmmss");
		LocalDateTime dateTime = LocalDateTime.now();
		String time = dateTime.format(dateTimeformatter);
		String id = "" + userId;
		String str = "" + time.substring(time.length() - 4, time.length()) + id.substring(id.length() - 2, id.length());
		int orderId = Integer.valueOf(str);
		Order o = new Order(orderId, dateTime, address, name, number * price, user.getId());
		GoodsInOrder goods = new GoodsInOrder(orderId, goodsId, number, number * price, capacity, front, rear, type);
		mapper.insertOrder(o);
		mapper.insertGoods(goods);
		// 更新库存
		goodsMapper.updateSalesVolume(number, type, goodsId);
	}

}
