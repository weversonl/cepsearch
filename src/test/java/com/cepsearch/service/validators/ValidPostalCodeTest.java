package com.cepsearch.service.validators;

import com.cepsearch.service.validators.impl.ValidPostalCodeImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.ConstraintValidatorContext;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ValidPostalCodeTest {

    private ValidPostalCodeImpl validator = new ValidPostalCodeImpl();

    @Test
    public void testIsValid_ValidPostalCode() {
        String validPostalCode = "12345678";
        assertTrue(validator.isValid(validPostalCode, mockConstraintValidatorContext()));
    }

    @Test
    public void testIsValid_NullPostalCode() {
        assertFalse(validator.isValid(null, mockConstraintValidatorContext()));
    }

    @Test
    public void testIsValid_EmptyPostalCode() {
        String emptyPostalCode = "";
        assertFalse(validator.isValid(emptyPostalCode, mockConstraintValidatorContext()));
    }

    @Test
    public void testIsValid_PostalCodeWithDash() {
        String postalCodeWithDash = "12345-678";
        assertTrue(validator.isValid(postalCodeWithDash, mockConstraintValidatorContext()));
    }

    @Test
    public void testIsValid_PostalCodeExceedingMaxLength() {
        String postalCodeExceedingMaxLength = "123456789";
        assertFalse(validator.isValid(postalCodeExceedingMaxLength, mockConstraintValidatorContext()));
    }

    private ConstraintValidatorContext mockConstraintValidatorContext() {
        return null;
    }

}
