package com.cepsearch.exception;

import com.cepsearch.exception.advice.DefaultControllerAdvice;
import com.cepsearch.exception.impl.NotFoundException;
import com.cepsearch.exception.impl.TechnicalException;
import com.cepsearch.exception.model.ApiErrorResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DefaultControllerAdviceTest {

    @InjectMocks
    private DefaultControllerAdvice defaultControllerAdvice;

    @Test
    public void testHandleNotFoundException() {

        NotFoundException exception = new NotFoundException();
        ResponseEntity<ApiErrorResponse> responseEntity = defaultControllerAdvice.handleNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

    }

    @Test
    public void testHandleTechnicalException() {

        TechnicalException exception = new TechnicalException();
        ResponseEntity<ApiErrorResponse> responseEntity = defaultControllerAdvice.handleTechnicalException(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());

    }
}