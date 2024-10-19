package com.cepsearch.domain.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    @DisplayName("Test Equals Location")
    void testEquals() {
        Location response1 = Location.builder()
                .type("x")
                .coordinates(new Coordinates())
                .build();

        Location response2 = Location.builder()
                .type("x")
                .coordinates(new Coordinates())
                .build();

        Location response3 = Location.builder()
                .type("y")
                .coordinates(new Coordinates())
                .build();

        assertEquals(response1, response2);

        assertNotEquals(response1, response3);
    }

    @Test
    @DisplayName("Test HashCode Location")
    void testHashCode() {
        Location response1 = Location.builder()
                .type("x")
                .coordinates(new Coordinates())
                .build();

        Location response2 = Location.builder()
                .type("x")
                .coordinates(new Coordinates())
                .build();

        Location response3 = Location.builder()
                .type("y")
                .coordinates(new Coordinates())
                .build();

        assertEquals(response1.hashCode(), response2.hashCode());

        assertNotEquals(response1.hashCode(), response3.hashCode());
    }

    @Test
    @DisplayName("Test ToString Location")
    void testToString() {
        Location response = Location.builder()
                .type("x")
                .coordinates(new Coordinates())
                .build();

        assertEquals("Location(type=x, coordinates=Coordinates(longitude=null, latitude=null))", response.toString());
    }

    @Test
    @DisplayName("Test Setters Location")
    void testSetters() {
        Location response = new Location();
        response.setType("x");
        response.setCoordinates(new Coordinates());
        assertEquals("x", response.getType());
        assertEquals(new Coordinates(), response.getCoordinates());

    }

    @Test
    @DisplayName("Test CanEqual Location")
    void testCanEqual() {
        Location response = new Location();
        assertTrue(response.canEqual(new Location()));
        assertFalse(response.canEqual(new Coordinates("x", "x")));
    }

    @Test
    @DisplayName("Test Default Constructor Location")
    void testDefaultConstructor() {
        Location response = new Location();
        assertNull(response.getCoordinates());
        assertNull(response.getType());
    }

}
