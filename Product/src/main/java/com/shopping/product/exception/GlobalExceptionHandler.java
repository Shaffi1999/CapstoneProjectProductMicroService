package com.shopping.product.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleConstructionNotFound(ProductNotFoundException ex)
	{
		ErrorResponse er=new ErrorResponse(new Date(),ex.getLocalizedMessage(),null);
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
	}
	
	
		
	
}
