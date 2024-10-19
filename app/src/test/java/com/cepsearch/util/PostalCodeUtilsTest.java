package com.cepsearch.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PostalCodeUtilsTest {

    @Test
    @DisplayName("Should return null when the postal code is blank")
    void cleanPostalCodeWhenPostalCodeIsBlank() {
        String postalCode = "";
        String cleanedPostalCode = PostalCodeUtils.cleanPostalCode(postalCode);

        assertNull(cleanedPostalCode);
    }

    @Test
    @DisplayName("Should return the postal code without hyphens and leading/trailing spaces")
    void cleanPostalCodeWhenPostalCodeHasHyphensAndSpaces() {
        String postalCode = " 123-456 ";
        String expected = "123456";
        String actual = PostalCodeUtils.cleanPostalCode(postalCode);

        assertEquals(expected, actual);
    }

}