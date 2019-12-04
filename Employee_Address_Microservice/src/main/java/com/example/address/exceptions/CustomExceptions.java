package com.example.address.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptions extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex){
		return new ResponseEntity<Object>("This is handled by Controller Advice "+ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<Object> handleInvaildId(IdNotFound ex){
		return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
	}
}
