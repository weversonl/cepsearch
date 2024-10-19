package com.cepsearch.exception.impl;

import com.cepsearch.enums.ResponseError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TechnicalException Test")
class TechnicalExceptionTest {

    @Test
    @DisplayName("Validate that the TechnicalException exception is being instantiated correctly")
    void testTechnicalException() {
        TechnicalException exception = new TechnicalException();
        Assertions.assertEquals(ResponseError.TECHNICAL_EXCEPTION.getStatusCode(), exception.getApiErrorResponse().getCode());
        Assertions.assertEquals(ResponseError.TECHNICAL_EXCEPTION.getMessage(), exception.getApiErrorResponse().getMessage());
        Assertions.assertEquals(ResponseError.TECHNICAL_EXCEPTION.getDescription(), exception.getApiErrorResponse().getDescription());
    }

}