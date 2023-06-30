package com.cepsearch.domain.dto;

import com.cepsearch.annotations.impl.PostalCodeValidationImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@DisplayName("PostalCodeDTO Test")
class PostalCodeDTOTest {

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    @Test
    @DisplayName("Should pass validation for a valid postal code")
    void isValidPostalCode() {
        PostalCodeDTO postalCodeDTO = PostalCodeDTO.builder()
                .postalCode("12345-678")
                .build();

        PostalCodeValidationImpl postalCodeValidation = new PostalCodeValidationImpl();
        boolean isValid = postalCodeValidation.isValid(postalCodeDTO.getPostalCode(), constraintValidatorContext);

        assertTrue(isValid);
    }

    @Test
    @DisplayName("Should fail validation for an invalid postal code")
    void isInvalidPostalCode() {
        PostalCodeDTO postalCodeDTO = PostalCodeDTO.builder()
                .postalCode("123456789")
                .build();

        PostalCodeValidationImpl postalCodeValidation = new PostalCodeValidationImpl();
        boolean isValid = postalCodeValidation.isValid(postalCodeDTO.getPostalCode(), constraintValidatorContext);

        assertFalse(isValid);
    }

    @Test
    @DisplayName("Should fail validation for a blank postal code")
    void isBlankPostalCode() {
        PostalCodeDTO postalCodeDTO = PostalCodeDTO.builder()
                .postalCode("")
                .build();

        PostalCodeValidationImpl postalCodeValidation = new PostalCodeValidationImpl();
        boolean isValid = postalCodeValidation.isValid(postalCodeDTO.getPostalCode(), constraintValidatorContext);

        assertFalse(isValid);
    }

}
