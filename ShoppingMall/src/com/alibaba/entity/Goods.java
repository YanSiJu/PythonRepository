package com.alibaba.entity;

public class Goods {

	public Goods(int id, String name, String batteryCapacity, String frontFacingCamera, String rearCamera) {
		super();
		this.id = id;
		this.name = name;
		this.batteryCapacity = batteryCapacity;
		this.frontFacingCamera = frontFacingCamera;
		this.rearCamera = rearCamera;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", batteryCapacity=" + batteryCapacity + ", frontFacingCamera="
				+ frontFacingCamera + ", rearCamera=" + rearCamera + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batteryCapacity == null) ? 0 : batteryCapacity.hashCode());
		result = prime * result + ((frontFacingCamera == null) ? 0 : frontFacingCamera.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rearCamera == null) ? 0 : rearCamera.hashCode());
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
		Goods other = (Goods) obj;
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
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rearCamera == null) {
			if (other.rearCamera != null)
				return false;
		} else if (!rearCamera.equals(other.rearCamera))
			return false;
		return true;
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

	private String name;
	private String batteryCapacity;
	private String frontFacingCamera;
	private String rearCamera;

}
