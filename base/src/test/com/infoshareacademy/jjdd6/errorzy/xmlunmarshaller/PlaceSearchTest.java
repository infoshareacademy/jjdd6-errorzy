package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlaceSearchTest {

    @Mock
    PlaceSearch placeSearch;

    @Test
    void testIfGetPlacesCorrectly() {
        //Given
        when(placeSearch.getPlaces()).thenReturn(mockedList());
        //When
        List<Place> result = placeSearch.getPlaces();
        //Then
        assertThat(result).hasSize(3);
    }

    @Test
    void getMapOfPlaces() {
        //Given
        when(placeSearch.getMapOfPlaces("Gdynia")).thenReturn(mockedPlaceMap());
        //When
        Map<String, Place> result = placeSearch.getMapOfPlaces("Gdynia");
        //Then
        assertThat(result).hasSize(3).containsKeys("Gdynia", "New York", "Sydney").doesNotContainKeys("Gdańsk", "Szczecin");

    }

    private List<Place> mockedList() {
        List<Place> createdMockedList = new ArrayList<>();
        createdMockedList.add(new Place(54.5189, 18.5305, "Gdynia", 0, null));
        createdMockedList.add(new Place(40.7128, -74.0060, "New York", 0, null));
        createdMockedList.add(new Place(-33.8688, 151.2093, "Sydney", 0, null));
        return createdMockedList;
    }

    private Map<String, Place> mockedPlaceMap() {
        Map<String, Place> createdMockedMap = new HashMap<>();
        createdMockedMap.put("Gdynia", new Place(54.5189, 18.5305, "Gdynia", 0, null));
        createdMockedMap.put("New York", new Place(40.7128, -74.0060, "New York", 0, null));
        createdMockedMap.put("Sydney", new Place(-33.8688, 151.2093, "Sydney", 0, null));
        return createdMockedMap;
    }
}
