package com.cepsearch.domain.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PostalCodeResponse Test")
class PostalCodeResponseTest {

    @Test
    @DisplayName("Test create PostalCodeResponse")
    void testCreatePostalCodeResponse() {
        String cep = "12345-678";
        String state = "Sample State";
        String city = "Sample City";
        String street = "Sample Street";
        String neighborhood = "Sample Neighborhood";
        Location location = Location.builder().type("x").coordinates(Coordinates.builder().latitude("1.5").longitude("1.5").build()).build();

        PostalCodeResponse postalCodeResponse = PostalCodeResponse.builder().cep(cep).state(state).city(city).street(street)
                .neighborhood(neighborhood).location(location).build();

        assertEquals(cep, postalCodeResponse.getCep());
        assertEquals(state, postalCodeResponse.getState());
        assertEquals(city, postalCodeResponse.getCity());
        assertEquals(street, postalCodeResponse.getStreet());
        assertEquals(neighborhood, postalCodeResponse.getNeighborhood());
        assertEquals(location, postalCodeResponse.getLocation());

    }

    @Test
    @DisplayName("Test Equals PostalCodeResponse")
    void testEquals() {
        PostalCodeResponse response1 = PostalCodeResponse.builder()
                .cep("12345678")
                .state("State 1")
                .city("City 1")
                .street("Street 1")
                .neighborhood("Neighborhood 1")
                .build();

        PostalCodeResponse response2 = PostalCodeResponse.builder()
                .cep("12345678")
                .state("State 1")
                .city("City 1")
                .street("Street 1")
                .neighborhood("Neighborhood 1")
                .build();

        PostalCodeResponse response3 = PostalCodeResponse.builder()
                .cep("87654321")
                .state("State 2")
                .city("City 2")
                .street("Street 2")
                .neighborhood("Neighborhood 2")
                .build();

        assertEquals(response1, response2);

        assertNotEquals(response1, response3);
    }

    @Test
    @DisplayName("Test HashCode PostalCodeResponse")
    void testHashCode() {
        PostalCodeResponse response1 = PostalCodeResponse.builder()
                .cep("12345678")
                .state("State 1")
                .city("City 1")
                .street("Street 1")
                .neighborhood("Neighborhood 1")
                .build();

        PostalCodeResponse response2 = PostalCodeResponse.builder()
                .cep("12345678")
                .state("State 1")
                .city("City 1")
                .street("Street 1")
                .neighborhood("Neighborhood 1")
                .build();

        PostalCodeResponse response3 = PostalCodeResponse.builder()
                .cep("87654321")
                .state("State 2")
                .city("City 2")
                .street("Street 2")
                .neighborhood("Neighborhood 2")
                .build();

        assertEquals(response1.hashCode(), response2.hashCode());

        assertNotEquals(response1.hashCode(), response3.hashCode());
    }

    @Test
    @DisplayName("Test ToString PostalCodeResponse")
    void testToString() {
        PostalCodeResponse response = PostalCodeResponse.builder()
                .cep("12345678")
                .state("State 1")
                .city("City 1")
                .street("Street 1")
                .neighborhood("Neighborhood 1")
                .build();

        assertEquals("PostalCodeResponse(cep=12345678, state=State 1, city=City 1, " +
                "street=Street 1, neighborhood=Neighborhood 1, location=null)", response.toString());
    }

    @Test
    @DisplayName("Test Setters PostalCodeResponse")
    void testSetters() {
        PostalCodeResponse response = new PostalCodeResponse();

        response.setCep("12345-678");
        response.setState("State1");
        response.setCity("City1");
        response.setStreet("Street1");
        response.setNeighborhood("Neighborhood1");
        response.setLocation(new Location("X", new Coordinates("1", "1")));

        assertEquals("12345-678", response.getCep());
        assertEquals("State1", response.getState());
        assertEquals("City1", response.getCity());
        assertEquals("Street1", response.getStreet());
        assertEquals("Neighborhood1", response.getNeighborhood());
        assertEquals(new Location("X", new Coordinates("1", "1")), response.getLocation());
    }

    @Test
    @DisplayName("Test CanEqual PostalCodeResponse")
    void testCanEqual() {
        PostalCodeResponse response = new PostalCodeResponse();
        assertTrue(response.canEqual(new PostalCodeResponse()));
        assertFalse(response.canEqual(new Location("X", new Coordinates("1", "1"))));
    }

    @Test
    @DisplayName("Test Default Constructor PostalCodeResponse")
    void testDefaultConstructor() {
        PostalCodeResponse response = new PostalCodeResponse();
        assertNull(response.getCep());
        assertNull(response.getState());
        assertNull(response.getCity());
        assertNull(response.getStreet());
        assertNull(response.getNeighborhood());
        assertNull(response.getLocation());
    }

}
