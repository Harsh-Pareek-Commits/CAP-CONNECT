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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="Answer")
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	private boolean ans_status;
	
	
	//answer to query Mapping
		@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)  
		@JoinColumn(name="query_id")
		private Query query; 
		
	//answer to user Mapping
		@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)  
		@JoinColumn(name="user_id")
		private User user; 
	
	public String getAns_body() {
		return ans_body;
	}

	/*
	 * public void setAns_body(String ans_body) { this.ans_body = ans_body; }
	 */
	public LocalDate getAns_date() {
		return ans_date;
	}
	public void setAns_date(LocalDate ans_date) {
		this.ans_date = ans_date;
	}
	public boolean isAns_status() {
		return ans_status;
	}
	public void setAns_status(boolean ans_status) {
		this.ans_status = ans_status;
	}
	
	public long getAns_id() {
		return ans_id;
	}
	public void setAns_id(long ans_id) {
		this.ans_id = ans_id;
	}
	public Answer(long ans_id, String ans_body, LocalDate ans_date, boolean ans_status) {
		super();
		this.ans_id = ans_id;
		this.ans_body = ans_body;
		this.ans_date = ans_date;
		this.ans_status = ans_status;
	}
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Answer [ans_id=" + ans_id + ", ans_body=" + ans_body + ", ans_date=" + ans_date + ", ans_status="
				+ ans_status + "]";
	}
	
	
	
	
	
	

}
