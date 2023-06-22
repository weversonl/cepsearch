package com.cepsearch.exception.impl;

import com.cepsearch.enums.ResponseError;
import com.cepsearch.exception.model.ApiErrorResponse;

import java.io.Serializable;

public class ApiException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -961505544915403534L;

    public ApiException(ResponseError responseError) {
        ApiErrorResponse.builder()
                .code(responseError.getStatusCode())
                .description(responseError.getDescription())
                .message(responseError.getMessage())
                .build();
    }

}
