package com.example.demo.exception;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
public class DevExceptionHandler {

	@ExceptionHandler(DevCreateException.class)
	public DevCreateException handleException(Exception e) {
		return null;
	}

	@ExceptionHandler(value = {
			HttpRequestMethodNotSupportedException.class,
			MethodArgumentNotValidException.class
	})
	public DevCreateException handleException2(Exception e, HttpServerErrorException e2) {
		return null;
	}

}
