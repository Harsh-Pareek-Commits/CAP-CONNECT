package com.cap.capconnect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long user_id;
	@Column(name="email")
	@NotNull(message="Should not be empty")
	private String email;
	@Column(name="name")
	@NotNull(message="Should not be empty")
	private String name;
	@Column(name="designation")
	@NotNull(message="Should not be empty")
	private String designation;
	@Column(name="password")
	@NotNull(message="Should not be empty")
	private String password;
	
	private int type;
	
	public long getUser_id() {
		return user_id;
	}

	/*
	 * public void setUser_id(long user_id) { this.user_id = user_id; }
	 */
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(long user_id, String email, String name, String designation, String password) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.name = name;
		this.designation = designation;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", email=" + email + ", name=" + name + ", designation=" + designation
				+ ", password=" + password + "]";
	}
	
	
	
}
