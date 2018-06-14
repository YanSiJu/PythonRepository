package com.alibaba.entity;

import java.util.List;

public class SortedGoodsInfo {
	public SortedGoodsInfo(List<Goods> g, List<GoodsImg> img, List<GoodsPrice> prices) {
		super();
		this.goods = g;
		this.image = img;
		this.prices = prices;
	}
	private List<Goods> goods;
	public List<Goods> getG() {
		return goods;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((prices == null) ? 0 : prices.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "SortedGoodsInfo [g=" + goods + ", img=" + image + ", prices=" + prices + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SortedGoodsInfo other = (SortedGoodsInfo) obj;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (prices == null) {
			if (other.prices != null)
				return false;
		} else if (!prices.equals(other.prices))
			return false;
		return true;
	}
	public List<GoodsImg> getImg() {
		return image;
	}
	public List<GoodsPrice> getPrices() {
		return prices;
	}
	private List<GoodsImg> image;
	private List<GoodsPrice> prices;

}
