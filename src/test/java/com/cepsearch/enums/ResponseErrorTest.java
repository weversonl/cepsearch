package com.cepsearch.enums;

import com.cepsearch.util.message.ExceptionMessages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class ResponseErrorTest {

    @Test
    public void testTechnicalException() {
        ResponseError error = ResponseError.TECHNICAL_EXCEPTION;
        assertEquals(500, error.getStatusCode());
        assertEquals(ExceptionMessages.TECHNICAL_EXCEPTION, error.getMessage());
        assertEquals(ExceptionMessages.TECHNICAL_DESCRIPTION, error.getDescription());
    }

    @Test
    public void testBadRequestException() {
        ResponseError error = ResponseError.BAD_REQUEST_EXCEPTION;
        assertEquals(400, error.getStatusCode());
        assertEquals(ExceptionMessages.BAD_REQUEST_EXCEPTION, error.getMessage());
        assertNull(error.getDescription());
    }

    @Test
    public void testNotFoundException() {
        ResponseError error = ResponseError.NOT_FOUND_EXCEPTION;
        assertEquals(404, error.getStatusCode());
        assertEquals(ExceptionMessages.NOT_FOUND_EXCEPTION, error.getMessage());
        assertEquals(ExceptionMessages.NOT_FOUND_DESCRIPTION, error.getDescription());
    }

}
