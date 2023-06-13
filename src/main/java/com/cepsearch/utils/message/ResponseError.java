package com.cepsearch.utils.message;

import lombok.Getter;

@Getter
public enum ResponseError {

    TECHNICAL_EXCEPTION(500, "Technical Exception", "There were technical errors in application"),
    BAD_REQUEST_EXCEPTION(400, "Bad Request Exception", "Bad Request"),
    NOT_FOUND_EXCEPTION(404, "Not Found", "It was not possible to find the postcard informed");

    private final Integer statusCode;
    private final String description;
    private final String message;

    ResponseError(int statusCode, String description, String message) {
        this.statusCode = statusCode;
        this.description = description;
        this.message = message;
    }

}
