package com.cepsearch.domain.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Test Equals Coordinates")
    void testEquals() {
        Coordinates response1 = Coordinates.builder()
                .latitude("x")
                .longitude("x")
                .build();

        Coordinates response2 = Coordinates.builder()
                .latitude("x")
                .longitude("x")
                .build();

        Coordinates response3 = Coordinates.builder()
                .latitude("y")
                .longitude("y")
                .build();

        assertEquals(response1, response2);

        assertNotEquals(response1, response3);
    }

    @Test
    @DisplayName("Test HashCode Coordinates")
    void testHashCode() {
        Coordinates response1 = Coordinates.builder()
                .latitude("x")
                .longitude("x")
                .build();

        Coordinates response2 = Coordinates.builder()
                .latitude("x")
                .longitude("x")
                .build();

        Coordinates response3 = Coordinates.builder()
                .latitude("y")
                .longitude("y")
                .build();

        assertEquals(response1.hashCode(), response2.hashCode());

        assertNotEquals(response1.hashCode(), response3.hashCode());
    }

    @Test
    @DisplayName("Test ToString Coordinates")
    void testToString() {
        Coordinates response = Coordinates.builder()
                .latitude("x")
                .longitude("x")
                .build();

        assertEquals("Coordinates(longitude=x, latitude=x)", response.toString());
    }

    @Test
    @DisplayName("Test Setters Coordinates")
    void testSetters() {
        Coordinates response = new Coordinates();
        response.setLatitude("x");
        response.setLongitude("x");
        assertEquals("x", response.getLatitude());
        assertEquals("x", response.getLongitude());

    }

    @Test
    @DisplayName("Test CanEqual Coordinates")
    void testCanEqual() {
        Coordinates response = new Coordinates();
        assertTrue(response.canEqual(new Coordinates()));
        assertFalse(response.canEqual(new Location()));
    }

    @Test
    @DisplayName("Test Default Constructor Coordinates")
    void testDefaultConstructor() {
        Coordinates response = new Coordinates();
        assertNull(response.getLatitude());
        assertNull(response.getLongitude());
    }

}
