package com.cepsearch.controller;

import com.cepsearch.dto.request.PostalCodeRequest;
import com.cepsearch.dto.response.PostalCodeResponse;
import com.cepsearch.service.PostalCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PostalCodeController {

    private final PostalCodeService postalCodeService;

    @GetMapping("/cep/{cep}")
    @Cacheable("ceps")
    public PostalCodeResponse findAddress(@PathVariable("cep") String cep) {
	return postalCodeService.findAddressByCep(new PostalCodeRequest(cep));
    }

}
