package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.userinput.GetUserInput;

public class ClosestStation {
    public final static double EARTH_RADIUS_IN_METERS = 6371*1000;

    public static double getDistanceBetweenTwoGeoPoints(double lat1, double lat2, Place place) {

        GetUserInput.getDoubleFromUser("Please insert geographic coordinate system (Longitude): ");

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(place.);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS_IN_METERS * c; // convert to meters

        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }
}
