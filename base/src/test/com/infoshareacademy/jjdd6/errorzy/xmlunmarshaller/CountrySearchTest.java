package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.Country;
import org.junit.jupiter.api.Assertions;
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
class CountrySearchTest {

    @Mock
    private CountrySearch countrySearch;
    private List<Country> mockedList;

    private String path = "/tmp/nextbike-live.xml";

    @BeforeEach
    void setupTest() {
        mockedList = new ArrayList<>();
        mockedList.add(new Country(null, 54.12312, 54.11231, "Country1"));
        mockedList.add(new Country(null, 12.121, 92.2121, "Country2"));
        mockedList.add(new Country(null, -12.214212, 22.3131, "Country3"));
        mockedList.add(new Country(null, 173.1231, -123.31231, "Country4"));
        mockedList.add(new Country(null, 12.2223, 83.2322, "Country5"));
    }

    @Test
    void testIfCountriesGetProperly() {
        //Given
        when(countrySearch.getCountries()).thenReturn(mockedList);
        //When
        List<Country> result = countrySearch.getCountries();
        //Then
        assertThat(result).hasSize(5);
    }

    @Test
    void testIfMapOfCountriesHasProperSize() {
        //Given
        when(countrySearch.getMapOfCountries()).thenReturn(mockedCountryMap());
        //When
        Map<String, Country> result = countrySearch.getMapOfCountries();
        //Then
        assertThat(result).hasSize(3)
                .containsKeys("Poland", "Germany", "Italy")
                .doesNotContainKeys("Russia");
    }

    private Map<String, Country> mockedCountryMap() {
        Map<String, Country> createdMockedMap = new HashMap<>();
        createdMockedMap.put("Germany", new Country(null, 12.2223, 83.2322, "Germany"));
        createdMockedMap.put("Poland", new Country(null, 54.2223, 18.2322, "Poland"));
        createdMockedMap.put("Italy", new Country(null, 54.2223, 34.2322, "Italy"));
        return createdMockedMap;
    }
}