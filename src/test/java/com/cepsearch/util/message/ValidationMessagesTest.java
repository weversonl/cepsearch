package com.cepsearch.util.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ValidationMessagesTest {

    @Test
    public void testInvalidPostalCodeMessage() {
        String message = ValidationMessages.INVALID_POSTAL_CODE;
        assertEquals("The postal code sent is invalid", message);
    }

    @Test
    public void testInvalidPostalCodeDescription() {
        String description = ValidationMessages.INVALID_POSTAL_CODE_DESCRIPTION;
        assertEquals("Custom validation annotation for postal codes", description);
    }

    @Test
    public void testValidPostalCodeExample() {
        String example = ValidationMessages.VALID_POSTAL_CODE_EXAMPLE;
        assertEquals("12345-678", example);
    }

}
