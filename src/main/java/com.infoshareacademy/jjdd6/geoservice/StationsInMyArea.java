package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StationsInMyArea {

    public List<Place> findStationsWithinRadius(double lat, double lng, double radiusInKilometers) {
        //TODO insert correct placeList.
        List<Place> placeList = ClosestStation.mockedPlaceList();
        ClosestStation closestStation = new ClosestStation();

        return placeList.stream()
                .filter(p -> closestStation.getDistanceBetweenTwoGeoPoints(lat, lng, p) <= radiusInKilometers)
                .collect(Collectors.toList());
    }

    public int getNumberOfStationsWithinRadius(List<Place> placeList) {
        return placeList.size();
    }
}