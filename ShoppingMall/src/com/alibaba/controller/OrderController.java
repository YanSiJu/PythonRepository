package com.alibaba.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.alibaba.entity.User;
import com.alibaba.service.impl.OrderServiceImpl;

@Controller
@RequestMapping("Order")
public class OrderController {

	@Autowired
	private OrderServiceImpl service;

	@RequestMapping("order")
	public String order(HttpServletRequest request, @RequestParam(value = "price", required = false) double price,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "color", required = false) String color,
			@RequestParam(value = "number", required = false) int number,
			@RequestParam(value = "rear", required = false) String rear,
			@RequestParam(value = "front", required = false) String front,
			@RequestParam(value = "capacity", required = false) String capacity,
			@RequestParam(value = "goodsId", required = false) int goodsId) {
		HttpSession session = request.getSession();
		@SuppressWarnings("unused")
		User user = (User) session.getAttribute("user");
		// if(user == null) {
		// return "login";
		// }
		session.setAttribute("number", number);
		session.setAttribute("color", color);
		session.setAttribute("type", type);
		session.setAttribute("price", price);
		session.setAttribute("front", front);
		session.setAttribute("rear", rear);
		session.setAttribute("capacity", capacity);
		session.setAttribute("goodsId", goodsId);
		return "order";
	}

	@RequestMapping("dealOrder")
	public String dealOrder(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int number = (int) session.getAttribute("number");
		String color = (String) session.getAttribute("color");
		String type = (String) session.getAttribute("type");
		double price = (double) session.getAttribute("price");
		String front = (String) session.getAttribute("front");
		String rear = (String) session.getAttribute("rear");
		String capacity = (String) session.getAttribute("capacity");
		int goodsId = (int) session.getAttribute("goodsId");
		service.createOrder(price, type, color, number, rear, front, capacity, user, goodsId);
		return "";
	}
}