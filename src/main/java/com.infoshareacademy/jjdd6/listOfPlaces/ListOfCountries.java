package com.infoshareacademy.jjdd6.listOfPlaces;

import com.infoshareacademy.jjdd6.errorzy.Country;

import java.util.*;

public class ListOfCountries {


    private List<Country> mockedCountries;

    public ListOfCountries() {
        mockedCountries.add(new Country(null, 46d, 18d, "Poland"));
        mockedCountries.add(new Country(null, 46d, 0d, "United Kingdom"));
        mockedCountries.add(new Country(null, 46d, 13d, "Germany"));
        mockedCountries.add(new Country(null, 43d, 4d, "France"));
        mockedCountries.add(new Country(null, 42d, 42d, "Russia"));
    }


    public ListOfCountries(List<Country> countries) {
        this.mockedCountries = countries;
    }


    public List<Country> getMockedCountries() {
        return mockedCountries;
    }

    public void getCitiesWithNextBike(String countryName) {
        Optional<Country> country = mockedCountries.stream()
                .filter(x -> x.getCountry().equals(countryName))
                .findFirst();

        country
                .map(c -> c.getCityList())
                .orElse(new ArrayList<>());


    }


}
