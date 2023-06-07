package com.cepsearch.service;

import com.cepsearch.dto.request.PostalCodeRequest;
import com.cepsearch.dto.response.PostalCodeResponse;

import javax.validation.Valid;

public interface PostalCodeService {

    PostalCodeResponse findAddressByCep(@Valid PostalCodeRequest request);

}
