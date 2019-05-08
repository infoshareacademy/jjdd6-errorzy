package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.PlaceSearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class StationsInMyAreaTest {

    private StationsInMyArea sut;
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
        mockedList.add(new Place(50.0808,8.2180,"Kurt-Schumacher-Ring (Campus Ost)", 0,null));
    }

    @Test
    void shouldFindStationsWithinRadius() {
        // given
        when(placeSearch.getPlaces()).thenReturn(mockedList);
        // when
        Place actualPlace = closestStation.findTheClosestPlace(50.0808, 9.0);
        // then
        Place expectedPlace = mockedList.get(3);
        assertThat(actualPlace).isEqualTo(expectedPlace);
    }

}
