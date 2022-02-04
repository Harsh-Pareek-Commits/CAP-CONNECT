package com.cap.capconnect.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Query {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long post_id;
	
	@NotNull(message="Should not be empty")
	@Column(name="title")
	private String title;
	
	@NotNull(message="Should not be empty")
	@Column(name="query_body")
	private String query_body;
	
	
	@Column(name="query_date")
	@FutureOrPresent(message = "Date cannot be past")
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	@JsonFormat(pattern="yyyy-MM-dd")
	private  LocalDate query_date;
	
	@NotNull(message="Should not be empty")
	@Column(name="query_status")
	private int query_status;
	


	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cate_info", referencedColumnName="cate_id")
	private Category category;
	//query to user Mapping
	@OneToOne(fetch=FetchType.EAGER)  
	@JoinColumn(name="user_info",referencedColumnName="user_id")
	private User user;
	public long getPost_id() {
		return post_id;
	}
	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuery_body() {
		return query_body;
	}
	public void setQuery_body(String query_body) {
		this.query_body = query_body;
	}
	public LocalDate getQuery_date() {
		return query_date;
	}
	public void setQuery_date(LocalDate query_date) {
		this.query_date = query_date;
	}
	public int getQuery_status() {
		return query_status;
	}
	public void setQuery_status(int query_status) {
		this.query_status = query_status;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Query(long post_id, @NotNull(message = "Should not be empty") String title,
			@NotNull(message = "Should not be empty") String query_body,
			@FutureOrPresent(message = "Date cannot be past") LocalDate query_date,
			@NotNull(message = "Should not be empty") int query_status, Category category, User user) {
		super();
		this.post_id = post_id;
		this.title = title;
		this.query_body = query_body;
		this.query_date = query_date;
		this.query_status = query_status;
		this.category = category;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Query [post_id=" + post_id + ", title=" + title + ", query_body=" + query_body + ", query_date="
				+ query_date + ", query_status=" + query_status + ", category=" + category + ", user=" + user + "]";
	}
	public Query() {
		super();
	} 
	
	

}