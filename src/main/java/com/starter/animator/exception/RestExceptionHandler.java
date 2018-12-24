package com.starter.animator.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(value = RestException.class)
	public ResponseEntity<List<ErrorBean>> handleRestException(RestException exception, HttpServletRequest request) {

		return new ResponseEntity<>(exception.getErrors(), exception.getHttpStatus());
	}

	@ExceptionHandler
	public ResponseEntity<List<ErrorBean>> handleException(Exception exception, HttpServletRequest request) {
		exception.printStackTrace();
		List<ErrorBean> errors = new ArrayList<>();
		errors.add(new ErrorBean("5000000", "Internal Server Error"));
		return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
