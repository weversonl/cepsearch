package com.cepsearch.controller;

import com.cepsearch.domain.dto.PostalCodeDTO;
import com.cepsearch.domain.response.PostalCodeResponse;
import com.cepsearch.service.PostalCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
@Tag(name = "Address search by postal code")
public class PostalCodeController {

    private final PostalCodeService postalCodeService;

    @GetMapping(value = "/cep/{cep}")
    @Operation(summary = "getting addresses", tags = "Address search by postal code")
    public PostalCodeResponse findAddress(@PathVariable("cep") String cep) {
        return postalCodeService.findAddressByCep(new PostalCodeDTO(cep.trim()));
    }

}
