package com.bdqn.entity;

public class Power {
//È¨ÏÞ±í
	private int id;
	private int fid;
	private int type;
	private String name;
	private String path;
	private String mbth;
	public String getMbth() {
		return mbth;
	}
	@Override
	public String toString() {
		return "Power [id=" + id + ", fid=" + fid + ", type=" + type + ", name=" + name + ", path=" + path + ", mbth="
				+ mbth + "]";
	}
	public void setMbth(String mbth) {
		this.mbth = mbth;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
