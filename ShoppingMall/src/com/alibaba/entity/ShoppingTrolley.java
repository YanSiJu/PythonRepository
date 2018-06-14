package com.alibaba.entity;

public class ShoppingTrolley {

	private int id;
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + userId;
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
		ShoppingTrolley other = (ShoppingTrolley) obj;
		if (id != other.id)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public ShoppingTrolley(int id, int userId) {
		super();
		this.id = id;
		this.userId = userId;
	}

	public ShoppingTrolley() {
	}

	@Override
	public String toString() {
		return "ShoppingTrolley [id=" + id + ", userId=" + userId + "]";
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
