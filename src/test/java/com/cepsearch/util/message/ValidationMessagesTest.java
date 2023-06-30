package com.cepsearch.util.message;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidationMessagesTest {

    @Test
    @DisplayName("Test invalid postal code message")
    void testInvalidPostalCodeMessage() {
        String message = ValidationMessages.INVALID_POSTAL_CODE;
        assertEquals("The postal code sent is invalid", message);
    }

    @Test
    @DisplayName("Test invalid postal code description")
    void testInvalidPostalCodeDescription() {
        String description = ValidationMessages.INVALID_POSTAL_CODE_DESCRIPTION;
        assertEquals("Custom validation annotation for postal codes", description);
    }

    @Test
    @DisplayName("Test valid postal code example")
    void testValidPostalCodeExample() {
        String example = ValidationMessages.VALID_POSTAL_CODE_EXAMPLE;
        assertEquals("12345-678", example);
    }
}