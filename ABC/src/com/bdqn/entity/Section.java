package com.bdqn.entity;

public class Section {
	//≤ø√≈±Ì
	private int id;
	private String name;
	private int count;
	public int getCount() {
		return count;
	}
	@Override
	public String toString() {
		return "Section [id=" + id + ", name=" + name + ", count=" + count + "]";
	}
	public void setCount(int count) {
		this.count = count;
	}
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
}
