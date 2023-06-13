package com.cepsearch.controller;

import com.cepsearch.dto.response.PostalCodeResponse;
import com.cepsearch.service.impl.PostalCodeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostalCodeControllerTest {

    @Mock
    private PostalCodeServiceImpl postalCodeService;

    @InjectMocks
    private PostalCodeController postalCodeController;

    @Test
    public void testFindAddress() {

        PostalCodeResponse expectedResponse = PostalCodeResponse.builder().cep("12345678").city("Sao Paulo").state("SP").build();

        when(postalCodeService.findAddressByCep(any())).thenReturn(expectedResponse);

        PostalCodeResponse actualResponse = postalCodeController.findAddress(anyString());

        assertEquals(expectedResponse, actualResponse);

    }

}
