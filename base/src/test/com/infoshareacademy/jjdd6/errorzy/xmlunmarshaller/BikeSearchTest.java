package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BikeSearchTest {

    @Mock
    BikeSearch bikeSearch;

    @Test
    void testIfGetMapOfBikesForPlaceProperlyExecuted() {
        //Given
        when(bikeSearch.getMapOfBikesForPlace("PlaceTest")).thenReturn(mockedBikeMap());
        //When
        Map<String, Bike> result = bikeSearch.getMapOfBikesForPlace("PlaceTest");
        //Then
        assertThat(result).hasSize(3);
    }

    private Map<String, Bike> mockedBikeMap() {
        Map<String, Bike> createdMockedMap = new HashMap<>();
        createdMockedMap.put("Bike1", new Bike(12324, 5));
        createdMockedMap.put("Bike2", new Bike(5678, 5));
        createdMockedMap.put("Bike3", new Bike(90123, 3));
        return createdMockedMap;
    }
}