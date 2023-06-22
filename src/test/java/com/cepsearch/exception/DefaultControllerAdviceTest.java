package com.cepsearch.exception;

import com.cepsearch.exception.advice.DefaultControllerAdvice;
import com.cepsearch.exception.model.ApiErrorResponse;
import com.cepsearch.util.message.ExceptionMessages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultControllerAdviceTest {

    @Mock
    private ConstraintViolationException constraintViolationException;

    @InjectMocks
    private DefaultControllerAdvice defaultControllerAdvice;

    @Test
    public void testHandleNotFoundException() {
        ResponseEntity<ApiErrorResponse> responseEntity = defaultControllerAdvice.handleNotFoundException();
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void testHandleTechnicalException() {
        ResponseEntity<ApiErrorResponse> responseEntity = defaultControllerAdvice.handleTechnicalException();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void onConstraintValidationException_ReturnsApiErrorResponse() {

        ConstraintViolation<?> constraintViolation = Mockito.mock(ConstraintViolation.class);
        Set<ConstraintViolation<?>> constraintViolations = new HashSet<>();
        constraintViolations.add(constraintViolation);
        when(constraintViolationException.getConstraintViolations()).thenReturn(constraintViolations);

        ApiErrorResponse apiErrorResponse = defaultControllerAdvice.onConstraintValidationException(constraintViolationException);

        assertEquals(HttpStatus.BAD_REQUEST.value(), apiErrorResponse.getCode().intValue());
        assertEquals(ExceptionMessages.BAD_REQUEST_EXCEPTION, apiErrorResponse.getMessage());
        assertNull(apiErrorResponse.getDescription());

    }

}