package com.springboot.coursemanagement.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Value(value = "${data.exception.message1}")
	private String message1;
	
	@ExceptionHandler(value = CourseNotFoundException.class)
	public ResponseEntity<String> courseNotFoundException(CourseNotFoundException courseNotFoundException) {
		return new ResponseEntity<String>(message1, HttpStatus.NOT_FOUND);
	}

}
