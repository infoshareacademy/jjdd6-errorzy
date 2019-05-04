package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountrySearchTest {

    @Mock
    private XmlUnmarshaller xmlUnmarshaller;
    @InjectMocks
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
        when(xmlUnmarshaller.getMarkersList(path).getCountryList()).thenReturn(List.of(
                new Country(null, 54.12312, 54.11231, "Country1"),
                new Country(null, 12.121, 92.2121, "Country2"),
                new Country(null, -12.214212, 22.3131, "Country3"),
                new Country(null, 173.1231, -123.31231, "Country4"),
                new Country(null, 12.2223, 83.2322, "Country5")));
        //When
        List<Country> result = countrySearch.getCountries();
        //Then
        assertThat(result).hasSize(5);
    }

    @Test
    void testIfMapOfCountriesHasProperSize() {
        //Given

        //When

        //Then
    }

}