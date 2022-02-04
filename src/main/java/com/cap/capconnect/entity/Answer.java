package com.cap.capconnect.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ans_id;
	
	@Column(name="ans_body")
	@NotNull(message="Should not be empty")
	private String ans_body;
	
	@Column(name="ans_date")
	@FutureOrPresent(message = "Date cannot be past")
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate ans_date;
	
	@Column(name="ans_status")
	@NotNull(message="Should not be empty")
	private int ans_status;
	//answer to query Mapping
	@OneToOne
	@JoinColumn(name="query_info",referencedColumnName="post_id")
	private Query query; 
	
//answer to user Mapping
	@OneToOne
	@JoinColumn(name="user_info",referencedColumnName="user_id")
	private User user;

	public long getAns_id() {
		return ans_id;
	}

	public void setAns_id(long ans_id) {
		this.ans_id = ans_id;
	}

	public String getAns_body() {
		return ans_body;
	}

	public void setAns_body(String ans_body) {
		this.ans_body = ans_body;
	}

	public LocalDate getAns_date() {
		return ans_date;
	}

	public void setAns_date(LocalDate ans_date) {
		this.ans_date = ans_date;
	}

	public int getAns_status() {
		return ans_status;
	}

	public void setAns_status(int ans_status) {
		this.ans_status = ans_status;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Answer(long ans_id, @NotNull(message = "Should not be empty") String ans_body,
			@FutureOrPresent(message = "Date cannot be past") LocalDate ans_date,
			@NotNull(message = "Should not be empty") int ans_status, Query query, User user) {
		super();
		this.ans_id = ans_id;
		this.ans_body = ans_body;
		this.ans_date = ans_date;
		this.ans_status = ans_status;
		this.query = query;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Answer [ans_id=" + ans_id + ", ans_body=" + ans_body + ", ans_date=" + ans_date + ", ans_status="
				+ ans_status + ", query=" + query + ", user=" + user + "]";
	}

	public Answer() {
		super();
	} 


}