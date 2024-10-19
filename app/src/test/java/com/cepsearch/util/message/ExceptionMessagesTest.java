package com.cepsearch.util.message;

import com.cepsearch.constants.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionMessagesTest {

    @Test
    @DisplayName("Validate that messages are being extracted correctly from Constants")
    void testConstants() {
        Assertions.assertEquals("Technical Exception", Constants.TECHNICAL_EXCEPTION);
        Assertions.assertEquals("Bad Request", Constants.BAD_REQUEST_EXCEPTION);
        Assertions.assertEquals("Not Found", Constants.NOT_FOUND_EXCEPTION);
        Assertions.assertEquals("There were technical errors in application", Constants.TECHNICAL_DESCRIPTION);
        Assertions.assertEquals("It was not possible to find the postcard informed", Constants.NOT_FOUND_DESCRIPTION);
    }

}