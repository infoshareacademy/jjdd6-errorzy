package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.PlaceSearch;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClosestStationTest {

    @Mock
    private PlaceSearch placeSearch;
    @InjectMocks
    private ClosestStation closestStation;

    private List<Place> mockedList;

    @BeforeEach
    void setupTest() {
        mockedList = new ArrayList<>();
        mockedList.add(new Place(54.5189, 18.5305, "Gdynia", 0, null));
        mockedList.add(new Place(40.7128, -74.0060, "New York", 0, null));
        mockedList.add(new Place(-33.8688, 151.2093, "Sydney", 0, null));
    }

    @Test
    void testDistanceBetweenTwoGeoPointsForValidInput() {
        assertThat(closestStation.getDistanceBetweenTwoGeoPoints(52.2297, 21.0122, mockedList.get(0)))
                .isNotNaN()
                .isPositive()
                .isCloseTo(303.100, Offset.offset(0.01));
    }

    @Test
    void testTheClosestPlaceIsCorrect() {
        //Given
        when(placeSearch.getPlaces()).thenReturn(mockedList);
        //When
        Place actualPlace = closestStation.findTheClosestPlace(52.5067, 13.2846);
        //Then
        Place expectedPlace = mockedList.get(0);
        assertThat(actualPlace).isEqualTo(expectedPlace);
    }

    @Test
    void testTheClosestPlaceIsIncorrect() {
        //Given
        when(placeSearch.getPlaces()).thenReturn(mockedList);
        //When
        Place actualPlace = closestStation.findTheClosestPlace(52.5067, 13.2846);
        //Then
        Place expectedPlace = mockedList.get(2);
        assertThat(actualPlace).isNotEqualTo(expectedPlace);
    }
}