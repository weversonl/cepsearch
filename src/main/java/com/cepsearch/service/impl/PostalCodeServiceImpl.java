package com.cepsearch.service.impl;

import com.cepsearch.client.PostalCodeClient;
import com.cepsearch.dto.request.PostalCodeRequest;
import com.cepsearch.dto.response.PostalCodeResponse;
import com.cepsearch.exception.impl.NotFoundException;
import com.cepsearch.exception.impl.TechnicalException;
import com.cepsearch.repository.RedisClientRepository;
import com.cepsearch.service.PostalCodeService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;

import static com.cepsearch.utils.message.ResponseError.NOT_FOUND_EXCEPTION;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class PostalCodeServiceImpl implements PostalCodeService {

    private final PostalCodeClient postalCodeClient;
    private final RedisClientRepository redisClientRepository;

    @Override
    public PostalCodeResponse findAddressByCep(@Valid PostalCodeRequest request) {
	try {
	    Optional<PostalCodeResponse> redis = redisClientRepository.findById(request.getPostalCode());
	    if (redis.isPresent()) {
		return redis.get();
	    }
	    PostalCodeResponse response = postalCodeClient.findByCep(request.getPostalCode());
	    redisClientRepository.save(response);
	    return response;
	} catch (FeignException.NotFound e) {
	    log.error("Error finding data -> " + NOT_FOUND_EXCEPTION.getMessage());
	    throw new NotFoundException();
	} catch (Exception e) {
	    log.error("API query error -> " + e.getMessage());
	    throw new TechnicalException();
	}
    }
}