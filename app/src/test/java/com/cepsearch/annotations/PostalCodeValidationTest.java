package com.cepsearch.annotations;

import com.cepsearch.constants.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("PostalCodeValidation Test")
class PostalCodeValidationTest {

    @Mock
    private PostalCodeValidation postalCodeValidation;

    @Test
    @DisplayName("Should return the custom message when it is provided")
    void descriptionReturnsCustomMessageWhenProvided() {
        String customMessage = "This is a custom message";
        when(postalCodeValidation.description()).thenReturn(customMessage);

        String description = postalCodeValidation.description();

        assertEquals(customMessage, description);
    }

    @Test
    @DisplayName("Should return the default message when no custom message is provided")
    void descriptionReturnsDefaultMessageWhenNoCustomMessageProvided() {

        String defaultMessage = Constants.INVALID_POSTAL_CODE_DESCRIPTION;
        String customMessage = "Custom validation annotation for postal codes";

        when(postalCodeValidation.description()).thenReturn(customMessage);

        String description = postalCodeValidation.description();
        String message = postalCodeValidation.message();

        assertEquals(customMessage, description);
        assertNotEquals(defaultMessage, message);
    }

}