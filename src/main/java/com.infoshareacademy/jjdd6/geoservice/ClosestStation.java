package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.PlacesProvider;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;

public class ClosestStation {
    public final static double EARTH_RADIUS_IN_METERS = 6371 * 1000;

    private PlacesProvider placesProvider;

    public ClosestStation(PlacesProvider placesProvider) {
        this.placesProvider = placesProvider;
    }

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
        distance = Math.pow(distance, 2);
        double roundStepOne = round((sqrt(distance) / 1000.0) * 1000.0);
        double roundStepTwo = roundStepOne / 1000.0;
        return roundStepTwo;
    }

    public Place findTheClosestPlace(double lat, double lng) {
        //TODO Insert List of places.
        List<Place> placeList = placesProvider.getPlaces();
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

    public static List<Place> mockedPlaceList() {
        Place place1 = new Place(54.32, -18.32, "Gdynia", 1, null);
        Place place2 = new Place(54.22, -18.38, "Gdańsk", 2, null);
        Place place3 = new Place( 53.47, -20.30, "Olsztyn", 3, null);
        Place place4 = new Place(54.44, -18.56, "Kwidzyn", 4, null);
        Place place5 = new Place(52.12, -21.02, "Warszawa", 5, null);
        List<Place> mockedPlaceList = new ArrayList<>();

        mockedPlaceList.add(place1);
        mockedPlaceList.add(place2);
        mockedPlaceList.add(place3);
        mockedPlaceList.add(place4);
        mockedPlaceList.add(place5);

        return mockedPlaceList;
    }
}