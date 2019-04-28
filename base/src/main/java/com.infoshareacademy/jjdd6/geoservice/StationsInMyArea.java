package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.PlaceSearch;

import java.util.List;
import java.util.stream.Collectors;

public class StationsInMyArea {
    private PlaceSearch placeSearch = new PlaceSearch();

    public List<Place> findStationsWithinRadius(double lat, double lng, double radiusInKilometers) {
        List<Place> placeList = placeSearch.getPlaces();
        ClosestStation closestStation = new ClosestStation();

        return placeList.stream()
                .filter(p -> closestStation.getDistanceBetweenTwoGeoPoints(lat, lng, p) <= radiusInKilometers)
                .collect(Collectors.toList());
    }

    public int getNumberOfStationsWithinRadius(List<Place> placeList) {
        return placeList.size();
    }
}