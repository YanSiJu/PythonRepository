package com.alibaba.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import com.alibaba.entity.GoodsImg;
import com.alibaba.entity.GoodsInOrder;
import com.alibaba.entity.GoodsPrice;
import com.alibaba.entity.Order;

@Service
public interface ShowOrderService {
	//通过用户名获取用户ID
		Integer getUserIdByUserName(@Param("userName")String userName);
		//通过用户ID查询该用户订单信息
		List<Order> getOrderInfo(@Param("userId")int userId);
		//通过订单信息获取订单号，并通过订单号获取商品在订单中的信息
		GoodsInOrder getGoodsInOrderInfoByOrderId(@Param("orderId")int orderId);
		//通过商品在订单中的信息获取商品ID，并通过商品ID获取商品名称
		String getGoodsNameByGoodsId(@Param("id")int goodsId);
		//通过商品ID和配置获取商品价格信息
		GoodsPrice getPriceByIdAndType(@Param("goodsId")int goodsId,@Param("type")String type);
		
		List<GoodsImg> getGoodsImg(@Param("goodsId")int goodsId);
		
		String getComment(@Param("userId")int userId,@Param("goodsId")int goodsId);
}
