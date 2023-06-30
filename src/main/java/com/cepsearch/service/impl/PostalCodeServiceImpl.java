package com.cepsearch.service.impl;

import com.cepsearch.client.PostalCodeClient;
import com.cepsearch.domain.dto.PostalCodeDTO;
import com.cepsearch.domain.response.PostalCodeResponse;
import com.cepsearch.exception.impl.NotFoundException;
import com.cepsearch.exception.impl.TechnicalException;
import com.cepsearch.service.PostalCodeService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import static com.cepsearch.enums.ResponseError.NOT_FOUND_EXCEPTION;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class PostalCodeServiceImpl implements PostalCodeService {

    private final PostalCodeClient postalCodeClient;

    @Override
    @Cacheable("postalcodes")
    public PostalCodeResponse findAddressByCep(@Valid PostalCodeDTO request) {

        try {
            return postalCodeClient.findByCep(request.getPostalCode());
        } catch (FeignException.NotFound e) {
            log.error(NOT_FOUND_EXCEPTION.getMessage());
            throw new NotFoundException();
        } catch (Exception e) {
            log.error("error on service: PostalCodeService -> " + e);
            log.error("{0}", e.getCause());
            throw new TechnicalException();
        }
    }
}
