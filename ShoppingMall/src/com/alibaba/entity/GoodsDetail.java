package com.alibaba.entity;

import java.util.List;

public class GoodsDetail {

	private List<Goods> goods;
	private List<GoodsImg> image;
	private List<GoodsPrice> prices;

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public List<GoodsImg> getImage() {
		return image;
	}

	public void setImage(List<GoodsImg> image) {
		this.image = image;
	}

	public List<GoodsPrice> getPrices() {
		return prices;
	}

	public GoodsDetail(List<Goods> goods, List<GoodsImg> image, List<GoodsPrice> prices) {
		super();
		this.goods = goods;
		this.image = image;
		this.prices = prices;
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
		return "GoodsDetail [goods=" + goods + ", image=" + image + ", prices=" + prices + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoodsDetail other = (GoodsDetail) obj;
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

	public void setPrices(List<GoodsPrice> prices) {
		this.prices = prices;
	}

}
