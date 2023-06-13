package com.cepsearch.utils.statics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TimeToLiveRedisTest {

    @Test
    public void testRescueTimeToLive() {

        int twentyFourHoursInSeconds = 86400;
        int time = TimeToLiveRedis.TWENTY_FOUR_HRS;

        assertEquals(twentyFourHoursInSeconds, time);
    }

}
