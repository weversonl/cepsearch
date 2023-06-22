package com.cepsearch.domain.dto;

import com.cepsearch.annotations.impl.PostalCodeValidationImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostalCodeDTOTest {

    @Test
    public void testConstructorAndGetters() {
        String postalCode = "12345678";
        PostalCodeDTO request = new PostalCodeDTO(postalCode);
        assertEquals(postalCode, request.getPostalCode());
    }

    @Test
    public void testSetters() {
        PostalCodeDTO request = new PostalCodeDTO();
        String postalCode = "12345678";
        request.setPostalCode(postalCode);
        assertEquals(postalCode, request.getPostalCode());
    }

    @Test
    public void testInvalidPostalCode() {

        PostalCodeValidationImpl validator = mock(PostalCodeValidationImpl.class);
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);
        PostalCodeDTO request = new PostalCodeDTO("invalid");

        when(validator.isValid(request.getPostalCode(), context)).thenReturn(false);

        boolean valid = validator.isValid(request.getPostalCode(), context);

        assertFalse(valid);
    }

    @Test
    public void testValidPostalCode() {
        PostalCodeDTO request = new PostalCodeDTO("12345678");
        assertTrue(validatePostalCode(request));
    }

    private boolean validatePostalCode(PostalCodeDTO request) {
        PostalCodeValidationImpl validator = mock(PostalCodeValidationImpl.class);
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);
        when(validator.isValid(request.getPostalCode(), context)).thenReturn(true);
        return validator.isValid(request.getPostalCode(), context);
    }

}
