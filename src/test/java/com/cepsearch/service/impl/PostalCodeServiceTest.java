package com.cepsearch.service.impl;

import com.cepsearch.client.PostalCodeClient;
import com.cepsearch.dto.request.PostalCodeRequest;
import com.cepsearch.dto.response.PostalCodeResponse;
import com.cepsearch.exception.impl.NotFoundException;
import com.cepsearch.exception.impl.TechnicalException;
import com.cepsearch.repository.RedisClientRepository;
import feign.FeignException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PostalCodeServiceTest {

    @Mock
    private PostalCodeClient postalCodeClient;

    @Mock
    private RedisClientRepository redisClientRepository;

    @InjectMocks
    private PostalCodeServiceImpl postalCodeService;

    @Test
    public void testFindAddressByCep_WithCachedData() {

        PostalCodeRequest request = new PostalCodeRequest("12345678");
        PostalCodeResponse cachedResponse = PostalCodeResponse.builder().cep("12345678").city("São Paulo").state("SP").build();
        when(redisClientRepository.findById(anyString())).thenReturn(Optional.of(cachedResponse));

        PostalCodeResponse response = postalCodeService.findAddressByCep(request);

        assertEquals(cachedResponse, response);
        verify(redisClientRepository, times(1)).findById(anyString());
        verifyNoInteractions(postalCodeClient);
        verify(redisClientRepository, never()).save(any());
    }

    @Test
    public void testFindAddressByCep_WithoutCachedData() {

        PostalCodeRequest request = new PostalCodeRequest("12345678");
        PostalCodeResponse apiResponse = PostalCodeResponse.builder().cep("12345678").city("São Paulo").state("SP").build();

        when(redisClientRepository.findById(anyString())).thenReturn(Optional.empty());
        when(postalCodeClient.findByCep(anyString())).thenReturn(apiResponse);

        PostalCodeResponse response = postalCodeService.findAddressByCep(request);

        assertEquals(apiResponse, response);
        verify(redisClientRepository, times(1)).findById(anyString());
        verify(postalCodeClient, times(1)).findByCep(anyString());
        verify(redisClientRepository, times(1)).save(apiResponse);
    }

    @Test
    public void testFindAddressByCep_WithFeignException() {

        PostalCodeRequest request = new PostalCodeRequest("12345678");
        when(redisClientRepository.findById(anyString())).thenReturn(Optional.empty());
        when(postalCodeClient.findByCep(anyString())).thenThrow(FeignException.NotFound.class);

        assertThrows(NotFoundException.class, () -> postalCodeService.findAddressByCep(request));
        verify(redisClientRepository, times(1)).findById("12345678");
        verify(postalCodeClient, times(1)).findByCep("12345678");
        verify(redisClientRepository, never()).save(any());
    }

    @Test
    public void testFindAddressByCep_WithOtherException() {

        PostalCodeRequest request = new PostalCodeRequest("12345678");
        when(redisClientRepository.findById(anyString())).thenReturn(Optional.empty());
        when(postalCodeClient.findByCep(anyString())).thenThrow(RuntimeException.class);

        assertThrows(TechnicalException.class, () -> postalCodeService.findAddressByCep(request));
        verify(redisClientRepository, times(1)).findById("12345678");
        verify(postalCodeClient, times(1)).findByCep("12345678");
        verify(redisClientRepository, never()).save(any());

    }

}
