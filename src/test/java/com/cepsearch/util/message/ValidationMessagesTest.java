package com.cepsearch.util.message;

import com.cepsearch.constants.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstantsTest {

    @Test
    @DisplayName("Test invalid postal code message")
    void testInvalidPostalCodeMessage() {
        String message = Constants.INVALID_POSTAL_CODE;
        assertEquals("The postal code sent is invalid", message);
    }

    @Test
    @DisplayName("Test invalid postal code description")
    void testInvalidPostalCodeDescription() {
        String description = Constants.INVALID_POSTAL_CODE_DESCRIPTION;
        assertEquals("Custom validation annotation for postal codes", description);
    }

    @Test
    @DisplayName("Test valid postal code example")
    void testValidPostalCodeExample() {
        String example = Constants.VALID_POSTAL_CODE_EXAMPLE;
        assertEquals("12345-678", example);
    }
}