package com.cepsearch.enums;

import com.cepsearch.util.message.ExceptionMessages;
import lombok.Getter;

@Getter
public enum ResponseError {

    TECHNICAL_EXCEPTION(500, ExceptionMessages.TECHNICAL_EXCEPTION, ExceptionMessages.TECHNICAL_DESCRIPTION),
    BAD_REQUEST_EXCEPTION(400, ExceptionMessages.BAD_REQUEST_EXCEPTION, null),
    NOT_FOUND_EXCEPTION(404, ExceptionMessages.NOT_FOUND_EXCEPTION, ExceptionMessages.NOT_FOUND_DESCRIPTION);

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

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

}
