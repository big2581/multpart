package com.big.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Upload implements Serializable {
	private Integer id;
	private String img;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date img_date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getImg_date() {
		return img_date;
	}
	public void setImg_date(Date img_date) {
		this.img_date = img_date;
	}
	@Override
	public String toString() {
		return "Upload [id=" + id + ", img=" + img + ", img_date=" + img_date + "]";
	}
	
}
