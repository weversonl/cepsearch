package com.cepsearch.util.message;

import lombok.Getter;

@Getter
public enum ResponseError {

    TECHNICAL_EXCEPTION(500, "Technical Exception", "There were technical errors with the API https://brasilapi.com.br/"),
    NOT_FOUND_EXCEPTION(404, "Not Found", "Could not connect to API https://brasilapi.com.br/");

    private final Integer statusCode;
    private final String description;
    private final String message;

    ResponseError(int statusCode, String description, String message) {
        this.statusCode = statusCode;
        this.description = description;
        this.message = message;
    }

}
