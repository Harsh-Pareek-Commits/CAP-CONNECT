package com.cap.capconnect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long cate_id;
	@Column(name="cate_name")
	@NotNull(message="Should not be empty")
	private String cate_name;
	public long getCate_id() {
		return cate_id;
	}

	
	public void setCate_id(long cate_id) {
		this.cate_id = cate_id;
	}


	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	
	public Category(long cate_id, String cate_name) {
		super();
		this.cate_id = cate_id;
		this.cate_name = cate_name;
	}
	public Category() {
		super();
		
	}
	@Override
	public String toString() {
		return "Category [cate_id=" + cate_id + ", cate_name=" + cate_name + "]";
	}
	
	
	
	
}
