package com.infoshareacademy.jjdd6.listOfPlaces;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;

import java.util.*;

public class MenuOptions {

    private Map<String, Country> countries;

    public MenuOptions(Map<String, Country > countries) {
        this.countries = countries;
    }


    public Optional<List<City>> getCitiesByCountry(Map<String, Country> countries, String countryName) {
        if (countries.containsKey(countryName)) {
            return Optional.of(countries.get(countryName).getCityList());
        } else {
            return Optional.empty();
        }
    }

    public Set<String> getCoutnries() {
        return countries.keySet();
    }

}
