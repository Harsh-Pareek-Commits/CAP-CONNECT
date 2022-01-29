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
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="Query")
public class Query {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	private boolean query_status;
	
	//Query to category Mapping
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name = "Query_Cate", joinColumns = { @JoinColumn(name = "post_id") }, inverseJoinColumns = { @JoinColumn(name = "cate_id") })
	
	//query to user Mapping
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)  
	@JoinColumn(name="user_id")
	private User user; 
	
	public long getPost_id() {
		return post_id;
	}

	/*
	 * public void setPost_id(long post_id) { this.post_id = post_id; }
	 */
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
	public boolean isQuery_status() {
		return query_status;
	}
	public void setQuery_status(boolean query_status) {
		this.query_status = query_status;
	}
	
	public Query(long post_id, String title, String query_body, LocalDate query_date, boolean query_status) {
		super();
		this.post_id = post_id;
		this.title = title;
		this.query_body = query_body;
		this.query_date = query_date;
		this.query_status = query_status;
	}
	public Query() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Query [post_id=" + post_id + ", title=" + title + ", query_body=" + query_body + ", query_date="
				+ query_date + ", query_status=" + query_status + "]";
	}
	
	
	
}

