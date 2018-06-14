package com.alibaba.entity;

public class SensitiveWord {

	private int id;
	private String word;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}
	public SensitiveWord(int id, String word) {
		super();
		this.id = id;
		this.word = word;
	}
	@Override
	public String toString() {
		return "SensitiveWord [id=" + id + ", word=" + word + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensitiveWord other = (SensitiveWord) obj;
		if (id != other.id)
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	public void setWord(String word) {
		this.word = word;
	}

}
