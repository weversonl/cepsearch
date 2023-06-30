package com.cepsearch.controller;

import com.cepsearch.domain.dto.PostalCodeDTO;
import com.cepsearch.domain.response.Coordinates;
import com.cepsearch.domain.response.Location;
import com.cepsearch.domain.response.PostalCodeResponse;
import com.cepsearch.service.PostalCodeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("PostalCodeController Test")
class PostalCodeControllerTest {

    @Mock
    private PostalCodeService postalCodeService;

    @InjectMocks
    private PostalCodeController postalCodeController;

    @Test
    @DisplayName("Should throw an exception when the postal code is invalid")
    void findAddressWhenPostalCodeIsInvalidThenThrowException() {
        String invalidPostalCode = "12345678";
        PostalCodeDTO postalCodeDTO = PostalCodeDTO.builder()
                .postalCode(invalidPostalCode)
                .build();

        when(postalCodeService.findAddressByCep(postalCodeDTO)).thenThrow(ConstraintViolationException.class);

        assertThrows(ConstraintViolationException.class, () -> postalCodeController.findAddress(invalidPostalCode));

        verify(postalCodeService, times(1)).findAddressByCep(postalCodeDTO);
    }

    @Test
    @DisplayName("Should return the address when the postal code is valid")
    void findAddressWhenPostalCodeIsValid() {

        String postalCode = "12345678";
        PostalCodeDTO postalCodeDTO = PostalCodeDTO.builder()
                .postalCode(postalCode)
                .build();
        PostalCodeResponse expectedResponse = PostalCodeResponse.builder()
                .cep(postalCode)
                .state("California")
                .city("Los Angeles")
                .street("Main Street")
                .neighborhood("Downtown")
                .location(Location.builder()
                        .type("Point")
                        .coordinates(Coordinates.builder()
                                .latitude("34.0522")
                                .longitude("-118.2437")
                                .build())
                        .build())
                .build();

        when(postalCodeService.findAddressByCep(any())).thenReturn(expectedResponse);

        PostalCodeResponse actualResponse = postalCodeController.findAddress(postalCode);

        assertEquals(expectedResponse, actualResponse);
        verify(postalCodeService, times(1)).findAddressByCep(postalCodeDTO);

    }

}