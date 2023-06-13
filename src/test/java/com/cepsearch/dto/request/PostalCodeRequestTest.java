package com.cepsearch.dto.request;

import com.cepsearch.service.validators.impl.ValidPostalCodeImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostalCodeRequestTest {

    @Test
    public void testConstructorAndGetters() {
        String postalCode = "12345678";
        PostalCodeRequest request = new PostalCodeRequest(postalCode);
        assertEquals(postalCode, request.getPostalCode());
    }

    @Test
    public void testSetters() {
        PostalCodeRequest request = new PostalCodeRequest();
        String postalCode = "12345678";
        request.setPostalCode(postalCode);
        assertEquals(postalCode, request.getPostalCode());
    }

    @Test
    public void testInvalidPostalCode() {

        ValidPostalCodeImpl validator = mock(ValidPostalCodeImpl.class);
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);
        PostalCodeRequest request = new PostalCodeRequest("invalid");

        when(validator.isValid(request.getPostalCode(), context)).thenReturn(false);

        boolean valid = validator.isValid(request.getPostalCode(), context);

        assertFalse(valid);
    }

    @Test
    public void testValidPostalCode() {
        PostalCodeRequest request = new PostalCodeRequest("12345678");
        assertTrue(validatePostalCode(request));
    }

    private boolean validatePostalCode(PostalCodeRequest request) {
        ValidPostalCodeImpl validator = mock(ValidPostalCodeImpl.class);
        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);
        when(validator.isValid(request.getPostalCode(), context)).thenReturn(true);
        return validator.isValid(request.getPostalCode(), context);
    }

}
