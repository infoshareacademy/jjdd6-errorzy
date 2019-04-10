package com.infoshareacademy.jjdd6.listOfPlaces;

import com.infoshareacademy.jjdd6.errorzy.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListOfCities {


    private List<City> mockedCities;

    public ListOfCities() {
        mockedCities.add(new City(46d, 18d, "Warsaw", null));
        mockedCities.add(new City(46d, 0d, "London", null));
        mockedCities.add(new City(46d, 13d, "Berlin", null));
        mockedCities.add(new City(43d, 4d, "Paris", null));
        mockedCities.add(new City(42d, 42d, "Moscow", null));
    }


    public ListOfCities(List<City> cities) {
        this.mockedCities = cities;
    }


    public List<City> getMockedCities() {
        return mockedCities;
    }

    public void getPlacesWithNaexBike(String CityName) {
        Optional<City> city = mockedCities.stream()
                .filter(x -> x.getName().equals(CityName))
                .findFirst();

        city
                .map(c -> c.getPlaceList())
                .orElse(new ArrayList<>());

    }


}


