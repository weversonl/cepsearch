package com.cepsearch.cep;

import com.cepsearch.client.CepSearchClient;
import com.cepsearch.exception.impl.NotFoundException;
import com.cepsearch.exception.impl.TechnicalException;
import com.cepsearch.model.cep.CepModel;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.cepsearch.util.message.ResponseError.NOT_FOUND_EXCEPTION;
import static com.cepsearch.util.message.ResponseError.TECHNICAL_EXCEPTION;

@Slf4j
@Service
public class CepSearchService {

    private final CepSearchClient cepSearchClient;

    @Autowired
    public CepSearchService(CepSearchClient cepSearchClient) {
        this.cepSearchClient = cepSearchClient;
    }

    public CepModel findAddressByCep(String cep) {
        try {

            return cepSearchClient.findByCep(cep);

        } catch (FeignException.NotFound e) {
            log.error("Error finding data -> " + NOT_FOUND_EXCEPTION.getMessage());
            throw new NotFoundException(NOT_FOUND_EXCEPTION);
        } catch (Exception e) {
            log.error("API query error -> " + e.getMessage());
            throw new TechnicalException(TECHNICAL_EXCEPTION);
        }
    }
}
