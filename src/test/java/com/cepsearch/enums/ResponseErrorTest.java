package com.cepsearch.enums;

import com.cepsearch.util.message.ExceptionMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ResponseError Enum Test")
class ResponseErrorTest {

    @Test
    @DisplayName("Should return correct status code for TECHNICAL_EXCEPTION")
    void statusCodeForTechnicalException() {
        ResponseError responseError = ResponseError.TECHNICAL_EXCEPTION;
        int expectedStatusCode = 500;

        int actualStatusCode = responseError.getStatusCode();

        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Test
    @DisplayName("Should return correct message for TECHNICAL_EXCEPTION")
    void messageForTechnicalException() {
        ResponseError responseError = ResponseError.TECHNICAL_EXCEPTION;
        String expectedMessage = ExceptionMessages.TECHNICAL_EXCEPTION;

        String actualMessage = responseError.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should return correct description for TECHNICAL_EXCEPTION")
    void descriptionForTechnicalException() {
        ResponseError responseError = ResponseError.TECHNICAL_EXCEPTION;
        String expectedDescription = ExceptionMessages.TECHNICAL_DESCRIPTION;

        String actualDescription = responseError.getDescription();

        assertEquals(expectedDescription, actualDescription);
    }

    @Test
    @DisplayName("Should return correct status code for BAD_REQUEST_EXCEPTION")
    void statusCodeForBadRequestException() {
        ResponseError responseError = ResponseError.BAD_REQUEST_EXCEPTION;
        int expectedStatusCode = 400;

        int actualStatusCode = responseError.getStatusCode();

        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Test
    @DisplayName("Should return correct message for BAD_REQUEST_EXCEPTION")
    void messageForBadRequestException() {
        ResponseError responseError = ResponseError.BAD_REQUEST_EXCEPTION;
        String expectedMessage = ExceptionMessages.BAD_REQUEST_EXCEPTION;

        String actualMessage = responseError.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}