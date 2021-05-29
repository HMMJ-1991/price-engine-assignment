package com.assessment.pricing.engine.engine.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assessment.pricing.engine.engine.dto.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PricingEngineException.class)
	public ResponseEntity<ApiResponse> handleDBProcedureException(PricingEngineException postSaleModificationException) {

		String message = postSaleModificationException.getMessage();
		Object data = postSaleModificationException.getData();
		return new ApiResponse.ApiResponseBuilder().withHttpStatus(HttpStatus.BAD_REQUEST).withMessage(message).withData(data).build();
	}

	// error handle for @Valid
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {

		// Get all errors from field validation
		List<String> errors = methodArgumentNotValidException.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());

		return new ApiResponse.ApiResponseBuilder().withHttpStatus(HttpStatus.BAD_REQUEST).withMessage(errors.toString()).build();
	}

}