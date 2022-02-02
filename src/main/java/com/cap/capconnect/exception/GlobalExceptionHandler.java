package com.cap.capconnect.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(QueryNotFoundException.class)
	public ResponseEntity<MyExceptionResponse> handleQueryException(QueryNotFoundException ex)
	{
		MyExceptionResponse exeResponse=new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
		exeResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AnswerNotFoundException.class)
	public ResponseEntity<MyExceptionResponse> handleQueryException(AnswerNotFoundException ex)
	{
		MyExceptionResponse exeResponse=new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
		exeResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<MyExceptionResponse> handleQueryException(UserNotFoundException ex)
	{
		MyExceptionResponse exeResponse=new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
		exeResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<MyExceptionResponse> handleQueryException(CategoryNotFoundException ex)
	{
		MyExceptionResponse exeResponse=new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
		exeResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers,HttpStatus status,WebRequest request){
		
		//fieldName,errorMsg
		Map<String,List<String>> map = new HashMap<>();
		List<String> myerrors=new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			myerrors.add( fieldName+" : "+error.getDefaultMessage());
			
			
		});
		map.put("message",myerrors);
		
	return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		
	}
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
