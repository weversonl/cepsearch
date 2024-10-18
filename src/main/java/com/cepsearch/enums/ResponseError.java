package com.cepsearch.enums;

import com.cepsearch.constants.Constants;
import lombok.Getter;

@Getter
public enum ResponseError {

    TECHNICAL_EXCEPTION(500, Constants.TECHNICAL_EXCEPTION, Constants.TECHNICAL_DESCRIPTION),
    BAD_REQUEST_EXCEPTION(400, Constants.BAD_REQUEST_EXCEPTION, null),
    NOT_FOUND_EXCEPTION(404, Constants.NOT_FOUND_EXCEPTION, Constants.NOT_FOUND_DESCRIPTION);

    private final Integer statusCode;
    private final String message;
    private final String description;

    ResponseError(int statusCode, String message, String description) {
        this.statusCode = statusCode;
        this.message = message;
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

}
