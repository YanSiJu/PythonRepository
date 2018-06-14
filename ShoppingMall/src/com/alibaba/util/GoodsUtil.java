package com.alibaba.util;

import java.util.List;
import java.util.Set;
import com.alibaba.entity.Goods;
import com.alibaba.entity.GoodsImg;
import com.alibaba.entity.GoodsInfo;
import com.alibaba.entity.GoodsPrice;

public enum GoodsUtil {
	UTIL;

	private Set<GoodsPrice> prices;
	private Set<GoodsImg> img;
	private List<Goods> goods;
	

	GoodsUtil() {

	}

	public void setInfo(GoodsInfo info) {
		prices = info.getPrices();
		img = info.getImg();
		goods = info.getGoods();
	}

	public void setPrices(Set<GoodsPrice> prices) {
		this.prices = prices;
	}

	public void setImg(Set<GoodsImg> img) {
		this.img = img;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public Set<GoodsPrice> getPrices() {
		return prices;
	}

	public Set<GoodsImg> getImg() {
		return img;
	}

	public List<Goods> getGoods() {
		return goods;
	}

}
