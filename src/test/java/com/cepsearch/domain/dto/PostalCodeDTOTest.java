package com.cepsearch.domain.dto;

import com.cepsearch.annotations.impl.PostalCodeValidationImpl;
import com.cepsearch.domain.response.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Test Equals PostalCodeDTO")
    void testEquals() {
        PostalCodeDTO response1 = PostalCodeDTO.builder()
                .postalCode("x")
                .build();

        PostalCodeDTO response2 = PostalCodeDTO.builder()
                .postalCode("x")
                .build();

        PostalCodeDTO response3 = PostalCodeDTO.builder()
                .postalCode("y")
                .build();

        assertEquals(response1, response2);

        assertNotEquals(response1, response3);
    }

    @Test
    @DisplayName("Test HashCode PostalCodeDTO")
    void testHashCode() {
        PostalCodeDTO response1 = PostalCodeDTO.builder()
                .postalCode("x")
                .build();

        PostalCodeDTO response2 = PostalCodeDTO.builder()
                .postalCode("x")
                .build();

        PostalCodeDTO response3 = PostalCodeDTO.builder()
                .postalCode("y")
                .build();

        assertEquals(response1.hashCode(), response2.hashCode());

        assertNotEquals(response1.hashCode(), response3.hashCode());
    }

    @Test
    @DisplayName("Test ToString PostalCodeDTO")
    void testToString() {
        PostalCodeDTO response = PostalCodeDTO.builder()
                .postalCode("x")
                .build();

        assertEquals("PostalCodeDTO(postalCode=x)", response.toString());
    }

    @Test
    @DisplayName("Test Setters PostalCodeDTO")
    void testSetters() {
        PostalCodeDTO response = new PostalCodeDTO();
        response.setPostalCode("x");
        assertEquals("x", response.getPostalCode());

    }

    @Test
    @DisplayName("Test CanEqual PostalCodeDTO")
    void testCanEqual() {
        PostalCodeDTO response = new PostalCodeDTO();
        assertTrue(response.canEqual(new PostalCodeDTO()));
        assertFalse(response.canEqual(new Location()));
    }

    @Test
    @DisplayName("Test Default Constructor PostalCodeDTO")
    void testDefaultConstructor() {
        PostalCodeDTO response = new PostalCodeDTO();
        assertNull(response.getPostalCode());
    }

}
