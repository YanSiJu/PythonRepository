package com.alibaba.entity;

public class GoodsPrice {
	
	public GoodsPrice(int goodsId, String type, double price, int quantity, int salesVolume, int state) {
		super();
		this.goodsId = goodsId;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.salesVolume = salesVolume;
		this.state = state;
	}

	private int goodsId;

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	@Override
	public String toString() {
		return "GoodsPrice [goodsId=" + goodsId + ", type=" + type + ", price=" + price + ", quantity=" + quantity
				+ ", salesVolume=" + salesVolume + ", state=" + state + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + goodsId;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + salesVolume;
		result = prime * result + state;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoodsPrice other = (GoodsPrice) obj;
		if (goodsId != other.goodsId)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (salesVolume != other.salesVolume)
			return false;
		if (state != other.state)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(int slaesVolume) {
		this.salesVolume = slaesVolume;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	// 手机型号
	private String type;
	private double price;
	// 库存
	private int quantity;
	// 销量
	private int salesVolume;
	// 上下架状态(1:上架 2:下架)
	private int state;

}
