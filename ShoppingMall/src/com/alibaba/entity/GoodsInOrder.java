package com.alibaba.entity;

public class GoodsInOrder {

	
	private int  orderId;
	private int  goodsId;
	private int quantity;
	private double amount;
	private String batteryCapacity;
	private String frontFacingCamera;
	private String rearCamera;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String type;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public String toString() {
		return "GoodsInOrder [orderId=" + orderId + ", goodsId=" + goodsId + ", quantity=" + quantity + ", amount="
				+ amount + ", batteryCapacity=" + batteryCapacity + ", frontFacingCamera=" + frontFacingCamera
				+ ", rearCamera=" + rearCamera + ", type=" + type + "]";
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
		result = prime * result + orderId;
		result = prime * result + quantity;
		result = prime * result + ((rearCamera == null) ? 0 : rearCamera.hashCode());
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
		GoodsInOrder other = (GoodsInOrder) obj;
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
		if (orderId != other.orderId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (rearCamera == null) {
			if (other.rearCamera != null)
				return false;
		} else if (!rearCamera.equals(other.rearCamera))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	public GoodsInOrder(int orderId, int goodsId, int quantity, double amount, String batteryCapacity,
			String frontFacingCamera, String rearCamera, String type) {
		super();
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.quantity = quantity;
		this.amount = amount;
		this.batteryCapacity = batteryCapacity;
		this.frontFacingCamera = frontFacingCamera;
		this.rearCamera = rearCamera;
		this.type = type;
	}
	
	
}
