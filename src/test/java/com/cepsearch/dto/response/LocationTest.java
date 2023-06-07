package com.cepsearch.dto.response;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LocationTest {

    @Test
    public void testLocation() {

	String longitude = "1.23456";
	String latitude = "4.56789";

	Coordinates coordinates = Coordinates.builder()
		.longitude(longitude)
		.latitude(latitude)
		.build();

	assertEquals(longitude, coordinates.getLongitude());
	assertEquals(latitude, coordinates.getLatitude());
    }

}
