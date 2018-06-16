package com.alibaba.service.impl;

import java.util.List;
import org.apache.ibatis.annotations.Param;
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
	public Integer getUserIdByUserName(@Param("userName") String userName) {

		// int userId = showOrderMapper.getUserIdByUserName(userName);
		showOrderMapper.getGoodsInfo();
		Integer userId = 0;
		return userId;
	}

	@Override
	public List<Order> getOrderInfo(@Param("userId") int userId) {

		List<Order> orderList = showOrderMapper.getOrderInfo(userId);

		return orderList;
	}

	@Override
	public GoodsInOrder getGoodsInOrderInfoByOrderId(@Param("orderId") int orderId) {

		GoodsInOrder gio = showOrderMapper.getGoodsInOrderInfoByOrderId(orderId);

		return gio;
	}

	@Override
	public String getGoodsNameByGoodsId(@Param("id") int goodsId) {

		String goodsName = showOrderMapper.getGoodsNameByGoodsId(goodsId);

		return goodsName;
	}

	@Override
	public GoodsPrice getPriceByIdAndType(@Param("goodsId") int goodsId, @Param("type") String type) {

		GoodsPrice goodsPrice = showOrderMapper.getPriceByIdAndType(goodsId, type);

		return goodsPrice;
	}

	@Override
	public List<GoodsImg> getGoodsImg(@Param("goodsId") int goodsId) {

		return showOrderMapper.getGoodsImg(goodsId);

	}

	@Override
	public String getComment(@Param("userId") int userId, @Param("goodsId") int goodsId) {

		return showOrderMapper.getComment(userId, goodsId);
	}

}
