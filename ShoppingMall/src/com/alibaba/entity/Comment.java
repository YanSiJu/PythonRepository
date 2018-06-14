package com.alibaba.entity;

public class Comment {

	private int userId;
	private int goodsId;
	private String content;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getContent() {
		return content;
	}

	public Comment(int userId, int goodsId, String content) {
		super();
		this.userId = userId;
		this.goodsId = goodsId;
		this.content = content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment [userId=" + userId + ", goodsId=" + goodsId + ", content=" + content + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + goodsId;
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
		Comment other = (Comment) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (goodsId != other.goodsId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

}
