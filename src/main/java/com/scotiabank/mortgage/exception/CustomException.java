package com.scotiabank.mortgage.exception;

import org.springframework.http.HttpStatus;

import com.scotiabank.mortgage.error.ErrorEnum;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final HttpStatus httpStatus;
	private final String message;
	private final ErrorEnum errorEnum;

	public CustomException(ErrorEnum errorEnum, HttpStatus httpStatus, String message) {
		this.errorEnum = errorEnum;
		this.httpStatus = httpStatus;
		this.message = message;
	}
}
