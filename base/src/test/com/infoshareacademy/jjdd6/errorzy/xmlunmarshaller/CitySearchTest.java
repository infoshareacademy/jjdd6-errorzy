package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.City;
import org.junit.jupiter.api.BeforeEach;
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
class CitySearchTest {

    @Mock
    CitySearch citySearch;

    private List<City> mockedList;

    @BeforeEach
    void setupTest() {
        mockedList = new ArrayList<>();
        mockedList.add(new City(54.5189, 18.5305, "Gdynia", null));
        mockedList.add(new City(40.7128, -74.0060, "New York", null));
        mockedList.add(new City(-33.8688, 151.2093, "Sydney", null));
    }

    @Test
    void testIfGetCitiesProperly() {
        //Given
        when(citySearch.getCities()).thenReturn(mockedList);
        //When
        List<City> result = citySearch.getCities();
        //Then
        assertThat(result).hasSize(3);
    }

    @Test
    void testIfGetMapOfCitiesForCountry() {
        //Given
        when(citySearch.getMapOfCitiesForCountry("Poland")).thenReturn(mockedCityMap());
        //When
        Map<String, City> result = citySearch.getMapOfCitiesForCountry("Poland");
        //Then
        assertThat(result).hasSize(3).containsKeys("Warszawa", "Gdansk", "Gdynia");
    }

    private Map<String, City> mockedCityMap() {
        Map<String, City> createdMockedMap = new HashMap<>();
        createdMockedMap.put("Warszawa", new City(12.2223, 83.2322, "Warszawa", null));
        createdMockedMap.put("Gdynia", new City(54.2223, 18.2322, "Gdynia", null));
        createdMockedMap.put("Gdansk", new City(54.2223, 34.2322, "Gdansk", null));
        return createdMockedMap;
    }
}
