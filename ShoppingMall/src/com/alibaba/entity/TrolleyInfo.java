package com.alibaba.entity;

import java.util.List;

public class TrolleyInfo {

	private int totalQuantity = 0;
	private double totalPrice = 0;
	private List<Integer> quantities;

	public List<Integer> getQuantities() {
		return quantities;
	}

	public void setQuantities(List<Integer> quantities) {
		this.quantities = quantities;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public TrolleyInfo(int totalQuantity, double totalPrice, List<goodsInShoppingtrolley> trolley, List<String> names,
			List<Double> prices,List<Integer> quantities) {
		super();
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.trolley = trolley;
		this.names = names;
		this.prices = prices;
		this.quantities = quantities;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "TrolleyInfo [totalQuantity=" + totalQuantity + ", totalPrice=" + totalPrice + ", quantities="
				+ quantities + ", trolley=" + trolley + ", names=" + names + ", prices=" + prices + "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((names == null) ? 0 : names.hashCode());
		result = prime * result + ((prices == null) ? 0 : prices.hashCode());
		result = prime * result + ((quantities == null) ? 0 : quantities.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + totalQuantity;
		result = prime * result + ((trolley == null) ? 0 : trolley.hashCode());
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
		TrolleyInfo other = (TrolleyInfo) obj;
		if (names == null) {
			if (other.names != null)
				return false;
		} else if (!names.equals(other.names))
			return false;
		if (prices == null) {
			if (other.prices != null)
				return false;
		} else if (!prices.equals(other.prices))
			return false;
		if (quantities == null) {
			if (other.quantities != null)
				return false;
		} else if (!quantities.equals(other.quantities))
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		if (totalQuantity != other.totalQuantity)
			return false;
		if (trolley == null) {
			if (other.trolley != null)
				return false;
		} else if (!trolley.equals(other.trolley))
			return false;
		return true;
	}

	public List<goodsInShoppingtrolley> getTrolley() {
		return trolley;
	}

	public void setTrolley(List<goodsInShoppingtrolley> trolley) {
		this.trolley = trolley;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public List<Double> getPrices() {
		return prices;
	}

	public void setPrices(List<Double> prices) {
		this.prices = prices;
	}

	private List<goodsInShoppingtrolley> trolley;
	private List<String> names;
	private List<Double> prices;
}
