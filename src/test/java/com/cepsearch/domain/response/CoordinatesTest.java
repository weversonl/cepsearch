package com.cepsearch.domain.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Coordinates Test")
class CoordinatesTest {

    @Test
    @DisplayName("Test create Coordinates object")
    void testCreateCoordinates() {
        String longitude = "123.456";
        String latitude = "-12.345";

        Coordinates coordinates = Coordinates.builder().longitude(longitude).latitude(latitude).build();

        assertEquals(longitude, coordinates.getLongitude());
        assertEquals(latitude, coordinates.getLatitude());
    }

}
