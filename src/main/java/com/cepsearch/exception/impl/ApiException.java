package com.cepsearch.exception.impl;

import com.cepsearch.exception.model.ApiErrorResponse;
import com.cepsearch.util.message.ResponseError;

import java.io.Serializable;

public class ApiException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 6293193333404309824L;

    public ApiException(ResponseError responseError) {
        ApiErrorResponse.builder()
                .code(responseError.getStatusCode())
                .description(responseError.getDescription())
                .message(responseError.getMessage())
                .build();
    }

}
