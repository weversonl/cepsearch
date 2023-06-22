package com.cepsearch.service;

import com.cepsearch.domain.dto.PostalCodeDTO;
import com.cepsearch.domain.response.PostalCodeResponse;

import javax.validation.Valid;

public interface PostalCodeService {

    PostalCodeResponse findAddressByCep(@Valid PostalCodeDTO request);

}
