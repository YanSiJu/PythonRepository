package com.alibaba.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.alibaba.entity.GoodsImg;
import com.alibaba.entity.GoodsInOrder;
import com.alibaba.entity.GoodsPrice;
import com.alibaba.entity.Order;

@Service
public interface ShowOrderService {
			//通过用户名获取用户ID
			Integer getUserIdByUserName(String userName);
			//通过用户ID查询该用户订单信息
			List<Order> getOrderInfo(int userId);
			//通过订单信息获取订单号，并通过订单号获取商品在订单中的信息
			GoodsInOrder getGoodsInOrderInfoByOrderId(int orderId);
			//通过商品在订单中的信息获取商品ID，并通过商品ID获取商品名称
			String getGoodsNameByGoodsId(int goodsId);
			//通过商品ID和配置获取商品价格
			GoodsPrice getPriceByIdAndType(int goodsId,String type);
			//获取商品图片
			GoodsImg getGoodsImg(int goodsId);
			
			String getComment(int userId,int goodsId);
}
