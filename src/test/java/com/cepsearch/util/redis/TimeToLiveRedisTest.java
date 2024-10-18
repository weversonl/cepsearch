package com.cepsearch.util.redis;

import com.cepsearch.constants.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeToLiveRedisTest {

    @Test
    @DisplayName("Test Redis Twenty Four Hours Constant")
    void testTwentyFourHrsConstant() {
        assertEquals(86400, Constants.TWENTY_FOUR_HRS);
    }
}