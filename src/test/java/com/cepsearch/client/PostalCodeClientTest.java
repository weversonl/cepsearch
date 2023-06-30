package com.cepsearch.client;

import com.cepsearch.domain.dto.PostalCodeDTO;
import com.cepsearch.domain.response.Coordinates;
import com.cepsearch.domain.response.Location;
import com.cepsearch.domain.response.PostalCodeResponse;
import com.cepsearch.exception.impl.TechnicalException;
import com.cepsearch.service.impl.PostalCodeServiceImpl;
import feign.FeignException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("PostalCodeClient Test")
class PostalCodeClientTest {

    @Mock
    private PostalCodeClient postalCodeClient;

    @InjectMocks
    private PostalCodeServiceImpl postalCodeService;

    @Test
    @DisplayName("Should throw an exception when an invalid CEP is provided")
    void findByCepWhenInvalidCepIsProvidedThenThrowException() {

        String invalidCep = "0123456789";
        PostalCodeDTO invalidPostalCodeDTO = new PostalCodeDTO(invalidCep);

        when(postalCodeClient.findByCep(invalidCep)).thenThrow(FeignException.class);

        assertThrows(TechnicalException.class, () -> postalCodeService.findAddressByCep(invalidPostalCodeDTO));

    }

    @Test
    @DisplayName("Should return the postal code response when a valid CEP is provided")
    void findByCepWhenValidCepIsProvided() {
        String validCep = "12345678";
        PostalCodeResponse expectedResponse = PostalCodeResponse.builder()
                .cep(validCep)
                .state("State")
                .city("City")
                .street("Street")
                .neighborhood("Neighborhood")
                .location(Location.builder()
                        .type("Type")
                        .coordinates(Coordinates.builder()
                                .latitude("123.456")
                                .longitude("456.789")
                                .build())
                        .build())
                .build();

        when(postalCodeClient.findByCep(anyString())).thenReturn(expectedResponse);

        PostalCodeResponse actualResponse = postalCodeService.findAddressByCep(new PostalCodeDTO(validCep));

        assertEquals(actualResponse, expectedResponse);
        verify(postalCodeClient, times(1)).findByCep(validCep);

    }

}