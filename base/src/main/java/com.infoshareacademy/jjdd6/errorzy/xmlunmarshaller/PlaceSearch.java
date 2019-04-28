package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.Place;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Stateless
public class PlaceSearch {

    private CitySearch citySearch = new CitySearch();

    public List<Place> getPlaces() {

        return citySearch.getCities().stream()
                .map(city -> city.getPlaceList())
                .flatMap(places -> places.stream())
                .collect(Collectors.toList());
    }

    public List<Place> getPlacesForCity(String cityName) {
        return citySearch.getCities().stream()
                .filter(x -> x.getName().equals(cityName))
                .flatMap(c -> c.getPlaceList().stream())
                .collect(Collectors.toList());
    }

    public Map<String, Place> getMapOfPlaces(String cityName) {
        Map<String, Place> placeMap = new TreeMap<>();

        for (Place place : getPlacesForCity(cityName)) {
            if (!placeMap.containsKey(place.getName())) {
                placeMap.put(place.getName(), place);
            }
        }
        return placeMap;
    }
}
