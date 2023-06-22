package com.cepsearch.client;

import com.cepsearch.domain.dto.PostalCodeDTO;
import com.cepsearch.domain.response.PostalCodeResponse;
import com.cepsearch.repository.RedisClientRepository;
import com.cepsearch.service.impl.PostalCodeServiceImpl;
import feign.FeignException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PostalCodeClientTest {

    @Mock
    private PostalCodeClient postalCodeClient;

    @Mock
    private RedisClientRepository redisClientRepository;

    @InjectMocks
    private PostalCodeServiceImpl postalCodeService;

    @Test
    public void testFindByCep() {

        PostalCodeResponse expectedResponse = PostalCodeResponse.builder().cep("12345678").city("Sao Paulo").state("SP").build();

        PostalCodeDTO postalCodeDTO = new PostalCodeDTO("12345678");

        when(redisClientRepository.findById(anyString())).thenReturn(Optional.empty());
        when(postalCodeClient.findByCep(anyString())).thenReturn(expectedResponse);

        PostalCodeResponse actualResponse = postalCodeService.findAddressByCep(postalCodeDTO);

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testFindByCep_FeignException() {

        String cep = "12345678";
        when(postalCodeClient.findByCep(cep)).thenThrow(FeignException.NotFound.class);
        assertThrows(FeignException.NotFound.class, () -> postalCodeClient.findByCep(cep));
        verify(postalCodeClient, times(1)).findByCep(cep);
    }

}
