package com.cap.capconnect.exception;

public class MyExceptionResponse {
	private int httpStatus;
	private String message;
	public int getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MyExceptionResponse(int httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}
	public MyExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
