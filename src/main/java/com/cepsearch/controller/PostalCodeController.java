package com.cepsearch.controller;

import com.cepsearch.dto.request.PostalCodeRequest;
import com.cepsearch.dto.response.PostalCodeResponse;
import com.cepsearch.service.impl.PostalCodeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PostalCodeController {

    private final PostalCodeServiceImpl postalCodeService;

    @GetMapping("/cep/{cep}")
    public PostalCodeResponse findAddress(@PathVariable("cep") String cep) {
        return postalCodeService.findAddressByCep(new PostalCodeRequest(cep));
    }

}
