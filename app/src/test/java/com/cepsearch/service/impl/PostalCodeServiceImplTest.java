package com.cepsearch.service.impl;

import com.cepsearch.client.PostalCodeClient;
import com.cepsearch.domain.dto.PostalCodeDTO;
import com.cepsearch.domain.response.Coordinates;
import com.cepsearch.domain.response.Location;
import com.cepsearch.domain.response.PostalCodeResponse;
import com.cepsearch.exception.impl.NotFoundException;
import com.cepsearch.exception.impl.TechnicalException;
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
@DisplayName("PostalCodeServiceImpl test")
class PostalCodeServiceImplTest {

    @Mock
    private PostalCodeClient postalCodeClient;

    @InjectMocks
    private PostalCodeServiceImpl postalCodeService;

    @Test
    @DisplayName("Should throw TechnicalException when an unexpected error occurs")
    void findAddressByCepWhenUnexpectedErrorOccursThenThrowTechnicalException() {
        PostalCodeDTO postalCodeDTO = PostalCodeDTO.builder()
                .postalCode("12345678")
                .build();

        when(postalCodeClient.findByCep(postalCodeDTO.getPostalCode()))
                .thenThrow(new RuntimeException("Unexpected error"));

        assertThrows(TechnicalException.class, () -> postalCodeService.findAddressByCep(postalCodeDTO));

        verify(postalCodeClient, times(1)).findByCep(postalCodeDTO.getPostalCode());
    }

    @Test
    @DisplayName("Should throw NotFoundException when the postal code is not found")
    void findAddressByCepWhenPostalCodeIsNotFoundThenThrowNotFoundException() {
        PostalCodeDTO postalCodeDTO = PostalCodeDTO.builder()
                .postalCode("12345678")
                .build();

        when(postalCodeClient.findByCep(postalCodeDTO.getPostalCode()))
                .thenThrow(FeignException.NotFound.class);

        assertThrows(NotFoundException.class, () -> postalCodeService.findAddressByCep(postalCodeDTO));

        verify(postalCodeClient, times(1)).findByCep(postalCodeDTO.getPostalCode());
    }

    @Test
    @DisplayName("Should return the address when the postal code is found")
    void findAddressByCepWhenPostalCodeIsFound() {
        PostalCodeDTO postalCodeDTO = PostalCodeDTO.builder()
                .postalCode("12345678")
                .build();

        PostalCodeResponse expectedResponse = PostalCodeResponse.builder()
                .cep("12345678")
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

        when(postalCodeClient.findByCep(postalCodeDTO.getPostalCode())).thenReturn(expectedResponse);

        PostalCodeResponse actualResponse = postalCodeService.findAddressByCep(postalCodeDTO);

        assertEquals(expectedResponse, actualResponse);
        verify(postalCodeClient, times(1)).findByCep(postalCodeDTO.getPostalCode());
    }

}