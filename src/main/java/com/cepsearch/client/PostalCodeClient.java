package com.cepsearch.client;

import com.cepsearch.dto.response.PostalCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CepSearch", url = "${app.client.brasilapi.cep.url}")
public interface PostalCodeClient {
    @GetMapping(path = "{cep}")
    PostalCodeResponse findByCep(@PathVariable(value = "cep") String cep);
}