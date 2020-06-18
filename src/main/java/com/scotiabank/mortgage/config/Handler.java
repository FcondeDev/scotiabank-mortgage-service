package com.scotiabank.mortgage.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.scotiabank.mortgage.dto.ApiErrorDTO;
import com.scotiabank.mortgage.error.ErrorEnum;
import com.scotiabank.mortgage.exception.CustomException;

import lombok.extern.java.Log;

@RestControllerAdvice
@Log
public class Handler {

	@ResponseBody
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<List<ApiErrorDTO>> handleException(MethodArgumentNotValidException exception) {

		List<ApiErrorDTO> errors = new ArrayList<>();
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {

			log.info(String.format("The bad request field : %s", fieldError.getField()));

			if (fieldError.getField().equals("downPayment"))
				errors.add(new ApiErrorDTO(ErrorEnum.VALIDATION_CONSTRAINT_DOWNPAYMENT.code,
						ErrorEnum.VALIDATION_CONSTRAINT_DOWNPAYMENT.title,
						ErrorEnum.VALIDATION_CONSTRAINT_DOWNPAYMENT.description));

			if (fieldError.getField().equals("loanLength"))
				errors.add(new ApiErrorDTO(ErrorEnum.VALIDATION_CONSTRAINT_LOAN.code,
						ErrorEnum.VALIDATION_CONSTRAINT_LOAN.title, ErrorEnum.VALIDATION_CONSTRAINT_LOAN.description));
		}
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	@ResponseBody
	@ExceptionHandler(value = CustomException.class)
	public ResponseEntity<ApiErrorDTO> handleException(CustomException exception) {
		log.info(String.format("There was a error on : %s", exception.getMessage()));
		return new ResponseEntity<>(new ApiErrorDTO(exception.getErrorEnum().code, exception.getErrorEnum().title,
				exception.getErrorEnum().description), HttpStatus.BAD_REQUEST);
	}
}
