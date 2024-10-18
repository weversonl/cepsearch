package com.cepsearch.service.impl;

import com.cepsearch.client.PostalCodeClient;
import com.cepsearch.domain.dto.PostalCodeDTO;
import com.cepsearch.domain.response.PostalCodeResponse;
import com.cepsearch.exception.impl.NotFoundException;
import com.cepsearch.exception.impl.TechnicalException;
import com.cepsearch.service.PostalCodeService;
import feign.FeignException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static com.cepsearch.enums.ResponseError.NOT_FOUND_EXCEPTION;

@Slf4j
@Service
@Validated
public class PostalCodeServiceImpl implements PostalCodeService {

    private final PostalCodeClient postalCodeClient;

    public PostalCodeServiceImpl(PostalCodeClient postalCodeClient) {
        this.postalCodeClient = postalCodeClient;
    }

    @Override
    @Cacheable("postalcodes")
    public PostalCodeResponse findAddressByCep(@Valid PostalCodeDTO request) {

        try {
            return postalCodeClient.findByCep(request.getPostalCode());
        } catch (FeignException.NotFound e) {
            log.error("{} CEP {}", NOT_FOUND_EXCEPTION.getMessage(), request.getPostalCode());
            throw new NotFoundException();
        } catch (Exception e) {
            log.error("error on service: PostalCodeService -> {}", String.valueOf(e));
            throw new TechnicalException();
        }
    }
}
