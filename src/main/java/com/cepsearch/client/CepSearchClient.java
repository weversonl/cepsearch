package com.cepsearch.client;

import com.cepsearch.model.cep.CepModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CepSearch", url = "${app.client.brasilapi.cep.url}")
public interface CepSearchClient {
    @GetMapping(path = "{cep}")
    CepModel findByCep(@PathVariable(value = "cep") String cep);
}