package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class CitySearchTest {

    @Mock
    CountrySearch countrySearch;
    @InjectMocks
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
    void getCities() {
        //Given
        when(countrySearch.getCountries()
                .stream()
                .map(Country::getCityList)
                .flatMap(Collection::stream)
                .distinct().collect(Collectors.toList())
        ).thenReturn(mockedList);
        //When
        List<City> result = citySearch.getCities();
        //Then
        assertThat(result).hasSize(3);
    }

    @Test
    void getMapOfCitiesForCountry() {
    }
}