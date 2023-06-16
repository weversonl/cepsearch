package com.cepsearch.utils.message;

import lombok.Getter;

@Getter
public enum ResponseError {

    TECHNICAL_EXCEPTION(500, "Technical Exception", "There were technical errors in application"),
    BAD_REQUEST_EXCEPTION(400, "Bad Request Exception", "Bad Request"),
    NOT_FOUND_EXCEPTION(404, "Not Found", "It was not possible to find the postcard informed");

    private final Integer statusCode;
    private final String message;
    private final String description;

    ResponseError(int statusCode, String message, String description) {
        this.statusCode = statusCode;
        this.message = message;
        this.description = description;
    }

}
