package com.cepsearch.exception.impl;

import com.cepsearch.enums.ResponseError;

import java.io.Serializable;

public class NotFoundException extends ApiException implements Serializable {

    private static final long serialVersionUID = 1050794036754112425L;

    public NotFoundException() {
        super(ResponseError.NOT_FOUND_EXCEPTION);
    }

}
