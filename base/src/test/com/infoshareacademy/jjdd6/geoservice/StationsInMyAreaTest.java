package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StationsInMyAreaTest {

    private StationsInMyArea stationsInMyArea;
    private List<Place> mockedList;

    @BeforeEach
    void setupTest() {
        stationsInMyArea = new StationsInMyArea();
        
        mockedList = new ArrayList<>();
        mockedList.add(new Place(54.5189, 18.5305, "Gdynia", 0, null));
        mockedList.add(new Place(52.2222, 19.3360, "Kutno", 0, null));
        mockedList.add(new Place(40.7128, -74.0060, "New York", 0, null));
        mockedList.add(new Place(-33.8688, 151.2093, "Sydney", 0, null));
    }


    @Test
    void testFindStationsWithinRadius() {
        assertThat(stationsInMyArea.findStationsWithinRadius(52.2297, 21.0122, 350, mockedList))
                .contains(mockedList.get(0), mockedList.get(1))
                .doesNotContain(mockedList.get(2), mockedList.get(3));
    }

    @Test
    void testFindStationsWithNullPlaceList() {
        assertThatThrownBy(() -> stationsInMyArea.findStationsWithinRadius(52.2297, 21.0122, 350, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testFindStationsWithNegativeRadius() {
        assertThat(stationsInMyArea.findStationsWithinRadius(52.2297, 21.0122, -2000, mockedList))
                .doesNotContainAnyElementsOf(mockedList)
                .hasSize(0);
    }


}