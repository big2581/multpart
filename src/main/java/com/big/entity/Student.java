package com.big.entity;

import java.io.Serializable;

public class Student implements Serializable{
	private Integer sid;
	private String sname;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
