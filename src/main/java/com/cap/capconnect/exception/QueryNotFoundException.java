package com.cap.capconnect.exception;

public class QueryNotFoundException  extends Exception {
	
	public QueryNotFoundException(String message)
	{
		super(message);
	}

	public QueryNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QueryNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public QueryNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public QueryNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}
