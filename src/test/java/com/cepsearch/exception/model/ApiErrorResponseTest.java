package com.cepsearch.exception.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ApiErrorResponse Test")
class ApiErrorResponseTest {

    @Test
    @DisplayName("Checks if ApiErrorResponse is building correctly")
    void testApiErrorResponse() {

        ApiErrorResponse errorResponse = ApiErrorResponse.builder()
                .code(500)
                .message("Internal Server Error")
                .description("An unexpected error occurred")
                .build();

        assertEquals(500, errorResponse.getCode());
        assertEquals("Internal Server Error", errorResponse.getMessage());
        assertEquals("An unexpected error occurred", errorResponse.getDescription());
    }
}