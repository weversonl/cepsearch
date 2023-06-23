package com.cepsearch.controller;

import com.cepsearch.domain.dto.PostalCodeDTO;
import com.cepsearch.domain.response.PostalCodeResponse;
import com.cepsearch.service.PostalCodeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
@Tag(name = "Postal Code Controller")
public class PostalCodeController {

    private final PostalCodeService postalCodeService;

    @GetMapping(value = "/cep/{cep}")
    public PostalCodeResponse findAddress(@PathVariable("cep") String cep) {
        return postalCodeService.findAddressByCep(new PostalCodeDTO(cep.trim()));
    }

}
