package com.cepsearch.domain.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Location Test")
class LocationTest {

    @Test
    @DisplayName("Test create Location object")
    void testLocation() {

        String longitude = "1.23456";
        String latitude = "4.56789";

        Coordinates coordinates = Coordinates.builder().longitude(longitude).latitude(latitude).build();

        assertEquals(longitude, coordinates.getLongitude());
        assertEquals(latitude, coordinates.getLatitude());
    }

}
