package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.PlaceSearch;

import java.util.List;

import static java.lang.Math.sqrt;

public class ClosestStation {
    public final static double EARTH_RADIUS_IN_METERS = 6371 * 1000;
    private PlaceSearch placeSearch = new PlaceSearch();

    public double getDistanceBetweenTwoGeoPoints(double lat1, double lng1, Place place) {

        double lat2 = place.getLat();
        double lng2 = place.getLng();
        double latDistance = Math.toRadians(lat2 - lat1);
        double lngDistance = Math.toRadians(lng2 - lng1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);
        double c = 2 * Math.atan2(sqrt(a), sqrt(1 - a));
        double distance = EARTH_RADIUS_IN_METERS * c;
        double distanceInKm = distance / 1000.0;
        return distanceInKm;
    }

    public Place findTheClosestPlace(double lat, double lng) {
        List<Place> placeList = placeSearch.getPlaces();
        Place closestPlace = placeList.get(0);
        double distanceToClosestStation = Double.MAX_VALUE;
        for (Place place : placeList) {
            double distanceToStation = getDistanceBetweenTwoGeoPoints(lat, lng, place);
            if (distanceToStation < distanceToClosestStation) {
                distanceToClosestStation = distanceToStation;
                closestPlace = place;
            }
        }
        return closestPlace;
    }
}