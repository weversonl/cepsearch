package com.cepsearch.controller;

import com.cepsearch.model.cep.CepModel;
import com.cepsearch.service.cep.CepSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CepController {

    private final CepSearchService cepSearchService;

    @Autowired
    public CepController(CepSearchService cepSearchService) {
        this.cepSearchService = cepSearchService;
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<CepModel> findAddress(@PathVariable("cep") String cep) {
        CepModel cepModelResponse = cepSearchService.findAddressByCep(cep);
        return ResponseEntity.ok(cepModelResponse);
    }
}
