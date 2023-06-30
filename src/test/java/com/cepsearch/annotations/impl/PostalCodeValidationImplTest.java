package com.cepsearch.annotations.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@DisplayName("PostalCodeValidationImpl Test")
class PostalCodeValidationImplTest {

    private PostalCodeValidationImpl postalCodeValidation;

    @BeforeEach
    void setUp() {
        postalCodeValidation = new PostalCodeValidationImpl();
    }

    @Test
    @DisplayName("Should return true when the postal code matches the defined pattern")
    void isValidWhenPostalCodeMatchesPattern() {
        ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);
        assertTrue(postalCodeValidation.isValid("12345-678", constraintValidatorContext));
        assertTrue(postalCodeValidation.isValid("12345678", constraintValidatorContext));
    }

    @Test
    @DisplayName("Should return false when the postal code is blank")
    void isValidWhenPostalCodeIsBlank() {
        ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);
        boolean result = postalCodeValidation.isValid("", constraintValidatorContext);
        assertFalse(result);
    }

    @Test
    @DisplayName("Should return false when the postal code does not match the defined pattern")
    void isValidWhenPostalCodeDoesNotMatchPattern() {
        ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);

        assertFalse(postalCodeValidation.isValid("12345", constraintValidatorContext));
        assertFalse(postalCodeValidation.isValid("123456789", constraintValidatorContext));
        assertFalse(postalCodeValidation.isValid("12345-1234", constraintValidatorContext));
        assertFalse(postalCodeValidation.isValid("012345678", constraintValidatorContext));
    }

}