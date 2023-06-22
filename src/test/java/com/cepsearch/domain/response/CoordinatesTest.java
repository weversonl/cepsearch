package com.cepsearch.domain.response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CoordinatesTest {

    @Test
    public void testCreateCoordinates() {
        String longitude = "123.456";
        String latitude = "-12.345";

        Coordinates coordinates = Coordinates.builder().longitude(longitude).latitude(latitude).build();

        assertEquals(longitude, coordinates.getLongitude());
        assertEquals(latitude, coordinates.getLatitude());
    }

}
