package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ClosestStationTest {

    private ClosestStation closestStation;
    private List<Place> mockedList;

    @BeforeEach
    void setupTest() {
        closestStation = new ClosestStation();

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
        Place expectedPlace = mockedList.get(0);
        Place actualPlace = closestStation.findTheClosestPlace(52.5067, 13.2846, mockedList);
        assertThat(actualPlace).isEqualTo(expectedPlace);
    }

    @Test
    void testTheClosestPlaceIsIncorrect() {
        Place expectedPlace = mockedList.get(2);
        Place actualPlace = closestStation.findTheClosestPlace(52.5067, 13.2846, mockedList);
        assertThat(actualPlace).isNotEqualTo(expectedPlace);
    }
}