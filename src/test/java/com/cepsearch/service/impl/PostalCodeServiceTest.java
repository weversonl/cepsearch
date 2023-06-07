package com.cepsearch.service.impl;

import com.cepsearch.client.PostalCodeClient;
import com.cepsearch.dto.request.PostalCodeRequest;
import com.cepsearch.dto.response.PostalCodeResponse;
import com.cepsearch.exception.impl.NotFoundException;
import com.cepsearch.exception.impl.TechnicalException;
import feign.FeignException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PostalCodeServiceTest {

    @Mock
    private PostalCodeClient postalCodeClient;

    @InjectMocks
    private PostalCodeServiceImpl postalCodeService;

    @Test
    public void testFindAddressByCep_Success() {

	PostalCodeResponse expectedResponse = PostalCodeResponse.builder()
		.cep("12345678")
		.city("Sao Paulo")
		.state("SP")
		.build();

	when(postalCodeClient.findByCep(anyString())).thenReturn(expectedResponse);

	PostalCodeRequest request = new PostalCodeRequest("12345678");
	PostalCodeResponse actualResponse = postalCodeService.findAddressByCep(request);

	verify(postalCodeClient, times(1)).findByCep("12345678");

	assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testFindAddressByCep_NotFoundException() {

	when(postalCodeClient.findByCep(any())).thenThrow(FeignException.NotFound.class);

	assertThrows(NotFoundException.class, () -> postalCodeService.findAddressByCep(new PostalCodeRequest("12345678")));

	verify(postalCodeClient, times(1)).findByCep("12345678");
    }

    @Test
    public void testFindAddressByCep_TechnicalException() {

	when(postalCodeClient.findByCep(any())).thenThrow(TechnicalException.class);

	assertThrows(TechnicalException.class, () -> postalCodeService.findAddressByCep(new PostalCodeRequest("12345678")));

	verify(postalCodeClient, times(1)).findByCep("12345678");
    }

}
