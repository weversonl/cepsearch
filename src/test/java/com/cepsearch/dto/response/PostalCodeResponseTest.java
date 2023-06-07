package com.cepsearch.dto.response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PostalCodeResponseTest {

    @Test
    public void testCreatePostalCodeResponse() {
	String cep = "12345-678";
	String state = "Sample State";
	String city = "Sample City";
	String street = "Sample Street";
	String neighborhood = "Sample Neighborhood";
	Location location = Location.builder()
		.type("x")
		.coordinates(Coordinates.builder()
			.latitude("1.5")
			.longitude("1.5")
			.build())
		.build();

	PostalCodeResponse postalCodeResponse = PostalCodeResponse.builder()
		.cep(cep)
		.state(state)
		.city(city)
		.street(street)
		.neighborhood(neighborhood)
		.location(location)
		.build();

	assertEquals(cep, postalCodeResponse.getCep());
	assertEquals(state, postalCodeResponse.getState());
	assertEquals(city, postalCodeResponse.getCity());
	assertEquals(street, postalCodeResponse.getStreet());
	assertEquals(neighborhood, postalCodeResponse.getNeighborhood());
	assertEquals(location, postalCodeResponse.getLocation());

    }

}
