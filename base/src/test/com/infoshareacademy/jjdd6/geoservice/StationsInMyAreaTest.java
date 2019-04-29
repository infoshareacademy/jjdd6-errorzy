package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class StationsInMyAreaTest {

    private StationsInMyArea stationsInMyArea;
    private List<Place> mockedList;

    @BeforeEach
    void setupTest() {
        stationsInMyArea = new StationsInMyArea();
        mockedList = new ArrayList<>();
    }

    @AfterEach
    void cleanAfterTest() {
        stationsInMyArea = null;
        mockedList = null;
    }

    @Test
    void testFindStationsWithinRadius() {
        Assertions.assertThat(stationsInMyArea.findStationsWithinRadius(52.2297, 21.0122, 350, createdMockedList()))
                .contains(createdMockedList().get(0), createdMockedList().get(1))
                .doesNotContain(createdMockedList().get(2), createdMockedList().get(3));
    }

    @Test
    void testFindStationsWithNullPlaceList() {
        Assertions.assertThatThrownBy(() -> stationsInMyArea.findStationsWithinRadius(52.2297, 21.0122, 350, null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void testFindStationsWithNegativeRadius() {
        Assertions.assertThat(stationsInMyArea.findStationsWithinRadius(52.2297, 21.0122, -2000, createdMockedList()))
                .doesNotContainAnyElementsOf(createdMockedList())
                .hasSize(0);
    }

    private List<Place> createdMockedList() {

        mockedList.add(new Place(54.5189, 18.5305, "Gdynia", 0, null));
        mockedList.add(new Place(52.2222, 19.3360, "Kutno", 0, null));
        mockedList.add(new Place(40.7128, -74.0060, "New York", 0, null));
        mockedList.add(new Place(-33.8688, 151.2093, "Sydney", 0, null));

        return mockedList;
    }
}