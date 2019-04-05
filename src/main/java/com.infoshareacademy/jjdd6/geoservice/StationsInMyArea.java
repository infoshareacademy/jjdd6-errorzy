package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;

import java.util.ArrayList;
import java.util.List;

public class StationsInMyArea {

    public List<Place> findStationsWithinRadius(double lat, double lng, double radius) {
        //TODO insert correct placeList.
        List<Place> placeList = ClosestStation.mockedPlaceList();
        ClosestStation closestStation = new ClosestStation();
        List<Place> placesWithinRadius = new ArrayList<>();

        for (Place place : placeList) {
            double distanceToStation = closestStation.getDistanceBetweenTwoGeoPoints(lat, lng, place);
            if (distanceToStation <= radius) {
                placesWithinRadius.add(place);
            }
        }
        return placesWithinRadius;
    }

    public int getNumberOfStationsWithinRadius(List<Place> placeList) {
        return placeList.size();
    }
}