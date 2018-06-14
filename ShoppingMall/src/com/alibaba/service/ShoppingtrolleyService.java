package com.alibaba.service;

import org.springframework.stereotype.Service;
import com.alibaba.entity.TrolleyInfo;

@Service
public interface ShoppingtrolleyService {

	// 修改购物车内商品数量
	public void modifyGoodsQuantity(int number, double amount, int shoppingtrolleyId, int goodsId);

	// 查看购物车内商品
	TrolleyInfo queryTrolley(int trolleyId);

	// 删除购物车内商品
	void deleteGoods(int goodsId, int shoppingtrolleyId);

	// 添加商品到购物车
	void addGoods(double price, int goodsId, int quantity, int shoppingtrolleyId, String rear, String front,
			String capacity, String type);

}
