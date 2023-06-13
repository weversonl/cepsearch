package com.cepsearch.exception.impl;

import com.cepsearch.utils.message.ResponseError;

import java.io.Serializable;

public class TechnicalException extends ApiException implements Serializable {

    private static final long serialVersionUID = -746537408915725028L;

    public TechnicalException() {
        super(ResponseError.TECHNICAL_EXCEPTION);
    }

}
