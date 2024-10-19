package com.cepsearch.exception.model;

import com.cepsearch.domain.response.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Test Equals ApiErrorResponse")
    void testEquals() {
        ApiErrorResponse response1 = ApiErrorResponse.builder()
                .code(500)
                .message("Internal Server Error")
                .description("An unexpected error occurred")
                .build();

        ApiErrorResponse response2 = ApiErrorResponse.builder()
                .code(500)
                .message("Internal Server Error")
                .description("An unexpected error occurred")
                .build();

        ApiErrorResponse response3 = ApiErrorResponse.builder()
                .code(400)
                .message("Bad Request")
                .description("Bad Request")
                .build();

        assertEquals(response1, response2);

        assertNotEquals(response1, response3);
    }

    @Test
    @DisplayName("Test HashCode ApiErrorResponse")
    void testHashCode() {
        ApiErrorResponse response1 = ApiErrorResponse.builder()
                .code(500)
                .message("Internal Server Error")
                .description("An unexpected error occurred")
                .build();

        ApiErrorResponse response2 = ApiErrorResponse.builder()
                .code(500)
                .message("Internal Server Error")
                .description("An unexpected error occurred")
                .build();

        ApiErrorResponse response3 = ApiErrorResponse.builder()
                .code(400)
                .message("Bad Request")
                .description("Bad Request")
                .build();

        assertEquals(response1.hashCode(), response2.hashCode());

        assertNotEquals(response1.hashCode(), response3.hashCode());
    }

    @Test
    @DisplayName("Test ToString ApiErrorResponse")
    void testToString() {
        ApiErrorResponse response = ApiErrorResponse.builder()
                .code(500)
                .message("Internal Server Error")
                .description("An unexpected error occurred")
                .build();

        assertEquals("ApiErrorResponse(code=500, message=Internal Server Error, description=An unexpected error occurred)", response.toString());
    }

    @Test
    @DisplayName("Test Setters ApiErrorResponse")
    void testSetters() {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setCode(500);
        response.setMessage("Internal Server Error");
        response.setDescription("An unexpected error occurred");
        assertEquals(500, response.getCode());
        assertEquals("Internal Server Error", response.getMessage());
        assertEquals("An unexpected error occurred", response.getDescription());

    }

    @Test
    @DisplayName("Test CanEqual ApiErrorResponse")
    void testCanEqual() {
        ApiErrorResponse response = new ApiErrorResponse();
        assertTrue(response.canEqual(new ApiErrorResponse()));
        assertFalse(response.canEqual(new Location()));
    }

    @Test
    @DisplayName("Test Default Constructor ApiErrorResponse")
    void testDefaultConstructor() {
        ApiErrorResponse response = new ApiErrorResponse();
        assertNull(response.getCode());
        assertNull(response.getMessage());
        assertNull(response.getDescription());
    }

}