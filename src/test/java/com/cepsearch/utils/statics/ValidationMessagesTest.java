package com.cepsearch.utils.statics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ValidationMessagesTest {

    @Test
    public void testInvalidCepMessage() {
	String message = ValidationMessages.INVALID_CEP;

	assertEquals("The postal code sent is invalid", message);
    }

}
