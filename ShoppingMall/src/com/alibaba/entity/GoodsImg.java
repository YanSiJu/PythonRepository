package com.alibaba.entity;

public class GoodsImg {

	private int goodsId;
	private String color;
	private String imgSrc;
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "GoodsImg [goodsId=" + goodsId + ", color=" + color + ", imgSrc=" + imgSrc + "]";
	}
	public String getImgSrc() {
		return imgSrc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + goodsId;
//		result = prime * result + ((imgSrc == null) ? 0 : imgSrc.hashCode());
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
		GoodsImg other = (GoodsImg) obj;
//		if (color == null) {
//			if (other.color != null)
//				return false;
//		} else if (!color.equals(other.color))
//			return false;
		if (goodsId != other.goodsId)
			return false;
//		if (imgSrc == null) {
//			if (other.imgSrc != null)
//				return false;
//		} else if (!imgSrc.equals(other.imgSrc))
//			return false;
		return true;
	}
	public GoodsImg(int goodsId, String color, String imgSrc) {
		super();
		this.goodsId = goodsId;
		this.color = color;
		this.imgSrc = imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
}
