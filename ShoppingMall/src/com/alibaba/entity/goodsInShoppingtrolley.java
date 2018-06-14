package com.alibaba.entity;

//保存购物车内的商品信息
public class goodsInShoppingtrolley {

	private int shoppingtrolleyId;
	private int goodsId;
	private String type;
	private String batteryCapacity;
	private String frontFacingCamera;
	private String rearCamera;

	// 数量
	private int quantity;

	public int getShoppingtrolleyId() {
		return shoppingtrolleyId;
	}

	@Override
	public String toString() {
		return "goodsInShoppingtrolley [shoppingtrolleyId=" + shoppingtrolleyId + ", goodsId=" + goodsId + ", type="
				+ type + ", batteryCapacity=" + batteryCapacity + ", frontFacingCamera=" + frontFacingCamera
				+ ", rearCamera=" + rearCamera + ", quantity=" + quantity + ", amount=" + amount + "]";
	}

	

	public String getType() {
		return type;
	}

	public goodsInShoppingtrolley(int shoppingtrolleyId, int goodsId, int quantity,double amount,String type, String batteryCapacity,
			String frontFacingCamera, String rearCamera) {
		super();
		this.shoppingtrolleyId = shoppingtrolleyId;
		this.goodsId = goodsId;
		this.type = type;
		this.batteryCapacity = batteryCapacity;
		this.frontFacingCamera = frontFacingCamera;
		this.rearCamera = rearCamera;
		this.quantity = quantity;
		this.amount = amount;
	}

	public goodsInShoppingtrolley(int shoppingtrolleyId, int goodsId, String type, String batteryCapacity,
			String frontFacingCamera, String rearCamera, int quantity, double amount) {
		super();
		this.shoppingtrolleyId = shoppingtrolleyId;
		this.goodsId = goodsId;
		this.type = type;
		this.batteryCapacity = batteryCapacity;
		this.frontFacingCamera = frontFacingCamera;
		this.rearCamera = rearCamera;
		this.quantity = quantity;
		this.amount = amount;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getFrontFacingCamera() {
		return frontFacingCamera;
	}

	public void setFrontFacingCamera(String frontFacingCamera) {
		this.frontFacingCamera = frontFacingCamera;
	}

	public String getRearCamera() {
		return rearCamera;
	}

	public void setRearCamera(String rearCamera) {
		this.rearCamera = rearCamera;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((batteryCapacity == null) ? 0 : batteryCapacity.hashCode());
		result = prime * result + ((frontFacingCamera == null) ? 0 : frontFacingCamera.hashCode());
		result = prime * result + goodsId;
		result = prime * result + quantity;
		result = prime * result + ((rearCamera == null) ? 0 : rearCamera.hashCode());
		result = prime * result + shoppingtrolleyId;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		goodsInShoppingtrolley other = (goodsInShoppingtrolley) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (batteryCapacity == null) {
			if (other.batteryCapacity != null)
				return false;
		} else if (!batteryCapacity.equals(other.batteryCapacity))
			return false;
		if (frontFacingCamera == null) {
			if (other.frontFacingCamera != null)
				return false;
		} else if (!frontFacingCamera.equals(other.frontFacingCamera))
			return false;
		if (goodsId != other.goodsId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (rearCamera == null) {
			if (other.rearCamera != null)
				return false;
		} else if (!rearCamera.equals(other.rearCamera))
			return false;
		if (shoppingtrolleyId != other.shoppingtrolleyId)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public void setShoppingtrolleyId(int shoppingtrolleyId) {
		this.shoppingtrolleyId = shoppingtrolleyId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	// 金额
	private double amount;

}
