package com.cepsearch.exception.impl;

import com.cepsearch.enums.ResponseError;
import com.cepsearch.exception.model.ApiErrorResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("ApiException Test")
class ApiExceptionTest {

    @Test
    @DisplayName("Should correctly set the status code when an ApiException is thrown")
    void apiExceptionSetsStatusCodeCorrectly() {
        ResponseError responseError = ResponseError.TECHNICAL_EXCEPTION;
        ApiException apiException = assertThrows(ApiException.class, () -> {
            throw new ApiException(responseError);
        });

        assertEquals(responseError.getStatusCode(), apiException.getApiErrorResponse().getCode());
    }

    @Test
    @DisplayName("Should correctly set the description when an ApiException is thrown")
    void apiExceptionSetsDescriptionCorrectly() {

        ResponseError responseError = ResponseError.TECHNICAL_EXCEPTION;
        ApiException apiException = assertThrows(ApiException.class, () -> {
            throw new ApiException(responseError);
        });

        ApiErrorResponse apiErrorResponse = apiException.getApiErrorResponse();

        assertEquals(responseError.getStatusCode(), apiErrorResponse.getCode());
        assertEquals(responseError.getMessage(), apiErrorResponse.getMessage());
        assertEquals(responseError.getDescription(), apiErrorResponse.getDescription());
    }

    @Test
    @DisplayName("Should correctly set the message when an ApiException is thrown")
    void apiExceptionSetsMessageCorrectly() {

        ResponseError responseError = ResponseError.TECHNICAL_EXCEPTION;
        ApiException apiException = assertThrows(ApiException.class, () -> {
            throw new ApiException(responseError);
        });

        ApiErrorResponse apiErrorResponse = apiException.getApiErrorResponse();

        assertEquals(responseError.getMessage(), apiErrorResponse.getMessage());
    }

}