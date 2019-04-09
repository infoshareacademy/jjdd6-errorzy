package com.infoshareacademy.jjdd6.ListOfPlaces;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;

import java.util.List;
import java.util.Optional;

public class ListOfCountries {


    private List<Country> countries;

    public ListOfCountries() {
        countries.add(new Country(null, 46d, 18d, "Poland"));
        countries.add(new Country(null, 46d, 0d, "United Kingdom"));
        countries.add(new Country(null, 46d, 13d, "Germany"));
        countries.add(new Country(null, 43d, 4d, "France"));
        countries.add(new Country(null, 42d, 42d, "Russia"));
    }


    public ListOfCountries(List<Country> countries) {
        this.countries = countries;
    }


    public List<Country> getCountries() {
        return countries;
    }

    public List<City> getCitiesWithNextBike(String countryName) {
        Optional<Country> country = countries.stream()
                .filter(x -> x.getCountry().equals(countryName))
                .findFirst();

        return country.get().getCityList();

    }

}
