package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;

public class ClosestStation {
    public final static double EARTH_RADIUS_IN_METERS = 6371*1000;

    public static double getDistanceBetweenTwoGeoPoints(double lat1, double lng1, Place place) {

        double lat2 = place.getLat();
        double lng2 = place.getLng();
        double latDistance = Math.toRadians(lat2 - lat1);
        double lngDistance = Math.toRadians(lng2 - lng1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);
        double c = 2 * Math.atan2(sqrt(a), sqrt(1 - a));
        double distance = EARTH_RADIUS_IN_METERS * c; // convert to meters

        distance = Math.pow(distance, 2);
        double roundStepOne = round((sqrt(distance)/1000.0)*1000.0);
        double roundStepTwo = roundStepOne/1000.0;

        return roundStepTwo;
    }
}
