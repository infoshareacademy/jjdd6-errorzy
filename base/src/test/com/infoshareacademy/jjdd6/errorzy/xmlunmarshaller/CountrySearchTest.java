package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.Country;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
class CountrySearchTest {



    private List<Country> mockedList;
    private CountrySearch countrySearch;

    @BeforeEach
    void setupTest() {
        countrySearch = new CountrySearch();

        mockedList = new ArrayList<>();
        mockedList.add(new Country(null, 54.12312, 54.11231, "Country1"));
        mockedList.add(new Country(null, 12.121, 92.2121, "Country2"));
        mockedList.add(new Country(null, -12.214212, 22.3131, "Country3"));
        mockedList.add(new Country(null, 173.1231, -123.31231, "Country4"));
        mockedList.add(new Country(null, 12.2223, 83.2322, "Country5"));
    }

    @Test
    void testIfCountriesGetProperly() {
        countrySearch.getCountries()
    }

    @Test
    void getMapOfCountries() {
    }
}