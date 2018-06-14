package com.alibaba.entity;

import java.util.List;
import java.util.Set;

public class GoodsInfo {

	private Set<GoodsPrice> prices;

	public Set<GoodsPrice> getPrices() {
		return prices;
	}

	public Set<GoodsImg> getImg() {
		return img;
	}

	public GoodsInfo(Set<GoodsPrice> prices, Set<GoodsImg> img, List<Goods> goods) {
		super();
		this.prices = prices;
		this.img = img;
		this.goods = goods;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	private Set<GoodsImg> img;
	private List<Goods> goods;
}
