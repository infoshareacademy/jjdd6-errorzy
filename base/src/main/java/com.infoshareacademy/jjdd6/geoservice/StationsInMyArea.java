package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.menu.InsideMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class StationsInMyArea {
    private static final Logger LOGGER = LogManager.getLogger(InsideMenu.class.getName());

    public List<Place> findStationsWithinRadius(double lat, double lng, double radiusInKilometers, List<Place> placeList) {
        ClosestStation closestStation = new ClosestStation();

        if (placeList == null) {
            LOGGER.warn("Place list is empty." );
            throw new NullPointerException("Place list is empty");
        }

        return placeList.stream()
                .filter(p -> closestStation.getDistanceBetweenTwoGeoPoints(lat, lng, p) <= radiusInKilometers)
                .collect(Collectors.toList());
    }
}