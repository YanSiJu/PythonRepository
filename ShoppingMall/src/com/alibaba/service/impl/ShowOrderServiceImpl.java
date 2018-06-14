package com.alibaba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.entity.GoodsImg;
import com.alibaba.entity.GoodsInOrder;
import com.alibaba.entity.GoodsPrice;
import com.alibaba.entity.Order;
import com.alibaba.mapper.ShowOrderMapper;
import com.alibaba.service.ShowOrderService;

@Service
public class ShowOrderServiceImpl implements ShowOrderService {
	
	@Autowired
	private ShowOrderMapper showOrderMapper;
	
	@Override
	public Integer getUserIdByUserName(String userName) {
		int userId = showOrderMapper.getUserIdByUserName(userName);

		return userId;
	}

	@Override
	public List<Order> getOrderInfo(int userId) {
		
		List<Order> orderList = showOrderMapper.getOrderInfo(userId);
		
		return orderList;
	}

	@Override
	public GoodsInOrder getGoodsInOrderInfoByOrderId(int orderId) {
		
		GoodsInOrder gio = showOrderMapper.getGoodsInOrderInfoByOrderId(orderId);
		
		return gio;
	}

	@Override
	public String getGoodsNameByGoodsId(int goodsId) {

		String goodsName = showOrderMapper.getGoodsNameByGoodsId(goodsId);
		
		return goodsName;
	}

	@Override
	public GoodsPrice getPriceByIdAndType(int goodsId, String type) {
		
		GoodsPrice goodsPrice = showOrderMapper.getPriceByIdAndType(goodsId, type);
		
		return goodsPrice;
	}
		
	@Override
	public GoodsImg getGoodsImg(int goodsId){
		
		return showOrderMapper.getGoodsImg(goodsId);
		
	}

	@Override
	public String getComment(int userId, int goodsId) {
		
		return showOrderMapper.getComment(userId, goodsId);
	}
	
}
