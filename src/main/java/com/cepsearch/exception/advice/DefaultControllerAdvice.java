package com.cepsearch.exception.advice;

import com.cepsearch.exception.impl.NotFoundException;
import com.cepsearch.exception.impl.TechnicalException;
import com.cepsearch.exception.model.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import static com.cepsearch.utils.message.ResponseError.*;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(NotFoundException e) {
	return ResponseEntity.status(NOT_FOUND_EXCEPTION.getStatusCode())
		.body(ApiErrorResponse.builder().code(NOT_FOUND_EXCEPTION.getStatusCode()).description(NOT_FOUND_EXCEPTION.getDescription())
			.message(NOT_FOUND_EXCEPTION.getMessage()).build());
    }

    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<ApiErrorResponse> handleTechnicalException(TechnicalException e) {
	return ResponseEntity.status(TECHNICAL_EXCEPTION.getStatusCode())
		.body(ApiErrorResponse.builder().code(TECHNICAL_EXCEPTION.getStatusCode()).description(TECHNICAL_EXCEPTION.getDescription())
			.message(TECHNICAL_EXCEPTION.getMessage()).build());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ApiErrorResponse onConstraintValidationException(ConstraintViolationException constraintViolations) {

	ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder().code(BAD_REQUEST_EXCEPTION.getStatusCode())
		.description(BAD_REQUEST_EXCEPTION.getDescription()).build();

	for (ConstraintViolation<?> violation : constraintViolations.getConstraintViolations()) {

	    String message = violation.getMessage(); // violation.getInvalidValue()
	    apiErrorResponse.setMessage(message);

	}

	return apiErrorResponse;

    }

}
