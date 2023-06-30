package com.cepsearch.util.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionMessagesTest {

    @Test
    @DisplayName("Validate that messages are being extracted correctly from ExceptionMessages")
    void testExceptionMessages() {
        Assertions.assertEquals("Technical Exception", ExceptionMessages.TECHNICAL_EXCEPTION);
        Assertions.assertEquals("Bad Request", ExceptionMessages.BAD_REQUEST_EXCEPTION);
        Assertions.assertEquals("Not Found", ExceptionMessages.NOT_FOUND_EXCEPTION);
        Assertions.assertEquals("There were technical errors in application", ExceptionMessages.TECHNICAL_DESCRIPTION);
        Assertions.assertEquals("It was not possible to find the postcard informed", ExceptionMessages.NOT_FOUND_DESCRIPTION);
    }

}