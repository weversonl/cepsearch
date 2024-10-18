package com.cepsearch.exception.advice;

import com.cepsearch.exception.model.ApiErrorResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.Set;

import static com.cepsearch.enums.ResponseError.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("DefaultControllerAdvice Test")
class DefaultControllerAdviceTest {

    @InjectMocks
    private DefaultControllerAdvice defaultControllerAdvice;


    @Test
    @DisplayName("Should return ApiErrorResponse with appropriate message when ConstraintViolationException is thrown")
    void onConstraintValidationExceptionReturnsAppropriateMessage() {
        ConstraintViolationException constraintViolationException = mock(ConstraintViolationException.class);
        Set<ConstraintViolation<?>> constraintViolations = new HashSet<>();
        ConstraintViolation<?> violation = mock(ConstraintViolation.class);
        when(violation.getMessage()).thenReturn("Invalid input");
        constraintViolations.add(violation);
        when(constraintViolationException.getConstraintViolations()).thenReturn(constraintViolations);

        ApiErrorResponse apiErrorResponse = defaultControllerAdvice.onConstraintValidationException(constraintViolationException);

        assertNotNull(apiErrorResponse);
        assertEquals(HttpStatus.BAD_REQUEST.value(), apiErrorResponse.getCode());
        assertEquals("Bad Request", apiErrorResponse.getMessage());
        assertEquals("Invalid input", apiErrorResponse.getDescription());
    }

    @Test
    @DisplayName("Should return ApiErrorResponse with BAD_REQUEST status code when ConstraintViolationException is thrown")
    void onConstraintValidationExceptionReturnsBadRequestStatusCode() {
        ConstraintViolationException constraintViolationException = mock(ConstraintViolationException.class);
        Set<ConstraintViolation<?>> constraintViolations = new HashSet<>();
        ConstraintViolation<?> violation = mock(ConstraintViolation.class);
        when(violation.getMessage()).thenReturn("Invalid input");
        constraintViolations.add(violation);
        when(constraintViolationException.getConstraintViolations()).thenReturn(constraintViolations);

        ApiErrorResponse expectedErrorResponse = ApiErrorResponse.builder()
                .code(BAD_REQUEST_EXCEPTION.getStatusCode())
                .message(BAD_REQUEST_EXCEPTION.getMessage())
                .description("Invalid input")
                .build();

        ApiErrorResponse actualErrorResponse = defaultControllerAdvice.onConstraintValidationException(constraintViolationException);

        assertNotNull(actualErrorResponse);
        assertEquals(expectedErrorResponse.getCode(), actualErrorResponse.getCode());
        assertEquals(expectedErrorResponse.getMessage(), actualErrorResponse.getMessage());
        assertEquals(expectedErrorResponse.getDescription(), actualErrorResponse.getDescription());
    }

    @Test
    @DisplayName("Should return ApiErrorResponse with description containing violation message when ConstraintViolationException is thrown")
    void onConstraintValidationExceptionReturnsDescriptionWithViolationMessage() {
        ConstraintViolationException constraintViolationException = mock(ConstraintViolationException.class);
        Set<ConstraintViolation<?>> constraintViolations = new HashSet<>();
        ConstraintViolation<?> violation = mock(ConstraintViolation.class);
        when(violation.getMessage()).thenReturn("Invalid input");
        constraintViolations.add(violation);
        when(constraintViolationException.getConstraintViolations()).thenReturn(constraintViolations);

        ApiErrorResponse expectedErrorResponse = ApiErrorResponse.builder()
                .code(BAD_REQUEST_EXCEPTION.getStatusCode())
                .message(BAD_REQUEST_EXCEPTION.getMessage())
                .description("Invalid input")
                .build();

        ApiErrorResponse actualErrorResponse = defaultControllerAdvice.onConstraintValidationException(constraintViolationException);

        assertNotNull(actualErrorResponse);
        assertEquals(expectedErrorResponse, actualErrorResponse);
    }

    @Test
    @DisplayName("Should return a response entity with technical exception details when a technical exception occurs")
    void handleTechnicalExceptionWhenOccurs() {

        ResponseEntity<ApiErrorResponse> responseEntity = defaultControllerAdvice.handleTechnicalException();

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());

        ApiErrorResponse apiErrorResponse = responseEntity.getBody();
        assertNotNull(apiErrorResponse);
        assertEquals(TECHNICAL_EXCEPTION.getStatusCode(), apiErrorResponse.getCode());
        assertEquals(TECHNICAL_EXCEPTION.getDescription(), apiErrorResponse.getDescription());
        assertEquals(TECHNICAL_EXCEPTION.getMessage(), apiErrorResponse.getMessage());
    }

    @Test
    @DisplayName("Should return ApiErrorResponse with NOT_FOUND status code when NotFoundException is thrown")
    void handleNotFoundExceptionReturnsApiErrorResponseWithNotFoundStatusCode() {

        ResponseEntity<ApiErrorResponse> response = defaultControllerAdvice.handleNotFoundException();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(NOT_FOUND_EXCEPTION.getStatusCode(), response.getBody().getCode());
        assertEquals(NOT_FOUND_EXCEPTION.getDescription(), response.getBody().getDescription());
        assertEquals(NOT_FOUND_EXCEPTION.getMessage(), response.getBody().getMessage());
    }
}