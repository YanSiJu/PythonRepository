package com.alibaba.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.entity.Goods;
import com.alibaba.entity.GoodsPrice;
import com.alibaba.entity.TrolleyInfo;
import com.alibaba.entity.goodsInShoppingtrolley;
import com.alibaba.mapper.GoodsMapper;
import com.alibaba.mapper.GoodsPriceMapper;
import com.alibaba.mapper.ShoppingTrolleyMapper;
import com.alibaba.service.ShoppingtrolleyService;

@Service
public class ShoppingtrolleyServiceImpl implements ShoppingtrolleyService {

	@Autowired
	private ShoppingTrolleyMapper mapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsPriceMapper priceMapper;

	@Override
	public void addGoods(double price, int goodsId, int quantity, int shoppingtrolleyId, String rear, String front,
			String capacity, String type) {
		List<goodsInShoppingtrolley> trolley = mapper.queryShoppingTrolleyByPK(goodsId, shoppingtrolleyId);
		System.out.println("\n\n\n-------goodsId:" + goodsId);
		System.out.println("\n\n\n-------shoppingtrolleyId:" + shoppingtrolleyId);
		System.out.print("\n\n\n-------加购物车:" + trolley + "\n\n\n\n");
		if (trolley != null && trolley.size() > 0) {
			// 更新商品数量和金额
			mapper.updateGoodsQuantity(quantity, price * quantity, shoppingtrolleyId, goodsId);
		} else {
			mapper.insertGoods(new goodsInShoppingtrolley(shoppingtrolleyId, goodsId, type, capacity, front, rear,
					quantity, quantity * price));
		}

	}

	@Override
	public void modifyGoodsQuantity(int number, double amount, int shoppingtrolleyId, int goodsId) {
		mapper.update(number, amount, shoppingtrolleyId, goodsId);
	}

	@Override
	public void deleteGoods(int goodsId, int shoppingtrolleyId) {
		mapper.deleteGoods(goodsId, shoppingtrolleyId);
	}

	@Override
	public TrolleyInfo queryTrolley(int trolleyId) {
		List<goodsInShoppingtrolley> trolley = mapper.queryTrolleyByTrolleyId(trolleyId);
		List<String> names = null;
		List<Double> prices = null;
		List<Integer> quantities = null;
		int totalQuantity = 0;
		double totalPrice = 0;
		if (trolley != null && trolley.size() > 0) {
			names = new ArrayList<>(trolley.size());
			quantities = new ArrayList<>(trolley.size());
			prices = new ArrayList<>(trolley.size());
			for (goodsInShoppingtrolley t : trolley) {
				int goodsId = t.getGoodsId();
				String type = t.getType();
				// 根据id查询name
				List<Goods> goods = goodsMapper.queryGoodsById(goodsId);
				if (goods != null && goods.size() > 0) {
					names.add(goods.get(0).getName());
				}
				// 根据id和Type查询price
				List<GoodsPrice> prcs = priceMapper.queryPricesByIdAndType(goodsId, type.replace("G", ""));
				if (prcs != null && prcs.size() > 0) {
					prices.add(prcs.get(0).getPrice());
					quantities.add(prcs.get(0).getQuantity());
				}
				totalPrice += t.getAmount();
				totalQuantity += t.getQuantity();
			}

		}
		return new TrolleyInfo(totalQuantity, totalPrice, trolley, names, prices, quantities);
	}

}
