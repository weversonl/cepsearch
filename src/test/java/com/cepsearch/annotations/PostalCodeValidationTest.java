package com.cepsearch.annotations;

import com.cepsearch.util.message.ValidationMessages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class PostalCodeValidationTest {

    @PostalCodeValidation
    private String postalCode;

    @Test
    public void testPostalCodeValidation() throws NoSuchFieldException {
        PostalCodeValidation annotation = PostalCodeValidationTest.class.getDeclaredField("postalCode")
                .getAnnotation(PostalCodeValidation.class);
        assertEquals(ValidationMessages.INVALID_POSTAL_CODE, annotation.message());
        assertEquals(ValidationMessages.INVALID_POSTAL_CODE_DESCRIPTION, annotation.description());
        assertEquals(ValidationMessages.VALID_POSTAL_CODE_EXAMPLE, annotation.example());
        assertNotNull(annotation.groups());
        assertNotNull(annotation.payload());
    }

}
