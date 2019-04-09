package com.infoshareacademy.jjdd6.ListOfPlaces;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Place;

import java.util.List;
import java.util.Optional;

public class ListOfCities {


    private List<City> cities;

    public ListOfCities() {
        cities.add(new City(46d, 18d, "Warsaw", null));
        cities.add(new City(46d, 0d, "London", null));
        cities.add(new City(46d, 13d, "Berlin", null));
        cities.add(new City(43d, 4d, "Paris", null));
        cities.add(new City(42d, 42d, "Moscow", null));
    }


    public ListOfCities(List<City> cities) {
        this.cities = cities;
    }


    public List<City> getCities() {
        return cities;
    }

    public List<Place> getPlacesWithNaexBike(String CityName) {
        Optional<City> city = cities.stream()
                .filter(x -> x.getName().equals(CityName))
                .findFirst();

        return city.get().getPlaceList();

    }


}


