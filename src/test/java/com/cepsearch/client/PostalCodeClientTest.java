package com.cepsearch.client;

import com.cepsearch.dto.request.PostalCodeRequest;
import com.cepsearch.dto.response.PostalCodeResponse;
import com.cepsearch.service.PostalCodeService;
import com.cepsearch.service.impl.PostalCodeServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostalCodeClientTest {

    @Mock
    private PostalCodeClient postalCodeClient;

    @InjectMocks
    private PostalCodeServiceImpl postalCodeService;

    @Test
    public void testFindByCep() {

	PostalCodeResponse expectedResponse = PostalCodeResponse.builder()
		.cep("12345678")
		.city("Sao Paulo")
		.state("SP")
		.build();

	PostalCodeRequest postalCodeRequest = PostalCodeRequest.builder()
		.postalCode("12345678")
		.build();

	when(postalCodeClient.findByCep(anyString())).thenReturn(expectedResponse);

	PostalCodeResponse actualResponse = postalCodeService.findAddressByCep(postalCodeRequest);

	assertEquals(expectedResponse, actualResponse);
    }

}
