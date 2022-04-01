package com.cepsearch.exception.advice;

import com.cepsearch.exception.impl.NotFoundException;
import com.cepsearch.exception.model.ApiErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.cepsearch.util.message.ResponseError.NOT_FOUND_EXCEPTION;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleTechnicalException(NotFoundException e) {
        return ResponseEntity
                .status(NOT_FOUND_EXCEPTION.getStatusCode())
                .body(ApiErrorResponse.builder()
                        .code(NOT_FOUND_EXCEPTION.getStatusCode())
                        .description(NOT_FOUND_EXCEPTION.getDescription())
                        .message(NOT_FOUND_EXCEPTION.getMessage())
                        .build());
    }
}
