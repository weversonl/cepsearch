package com.cepsearch.utils.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ResponseErrorTest {

    @Test
    public void testResponseErrorProperties() {
	ResponseError error = ResponseError.TECHNICAL_EXCEPTION;

	assertEquals(Integer.valueOf(500), error.getStatusCode());
	assertEquals("Technical Exception", error.getDescription());
	assertEquals("There were technical errors with the API https://brasilapi.com.br/", error.getMessage());
    }

}
