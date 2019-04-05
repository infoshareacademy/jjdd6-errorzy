package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;

import java.util.List;

public class StationsInMyArea {
    public List<Place> findStationsInArea(double lat, double lng, double radius) {
        //TODO insert correct placeList.
        List<Place> placeList = ClosestStation.mockedPlaceList();
        ClosestStation closestStation = new ClosestStation();

        for (Place place : placeList) {

            closestStation.getDistanceBetweenTwoGeoPoints();
        }


        return null;
    }
}
