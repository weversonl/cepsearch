package com.cepsearch.exception.impl;

import com.cepsearch.enums.ResponseError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("NotFoundException Test")
class NotFoundExceptionTest {

    @Test
    @DisplayName("Validate that the NotFoundException exception is being instantiated correctly")
    void testNotFoundException() {
        NotFoundException exception = new NotFoundException();
        Assertions.assertEquals(ResponseError.NOT_FOUND_EXCEPTION.getStatusCode(), exception.getApiErrorResponse().getCode());
        Assertions.assertEquals(ResponseError.NOT_FOUND_EXCEPTION.getMessage(), exception.getApiErrorResponse().getMessage());
        Assertions.assertEquals(ResponseError.NOT_FOUND_EXCEPTION.getDescription(), exception.getApiErrorResponse().getDescription());
    }

}