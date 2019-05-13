package com.infoshareacademy.jjdd6.geoservice;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.menu.InsideMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class StationsInMyArea {

    private static final Logger LOGGER = LogManager.getLogger(InsideMenu.class.getName());
    @Inject
    private ClosestStation closestStation;

    public List<Place> findStationsWithinRadius(double lat, double lng, double radiusInKilometers, List<Place> placeList) {

        if (placeList == null) {
            LOGGER.warn("Place list is empty.");
            throw new IllegalArgumentException("Place list is empty");
        }

        return placeList.stream()
                .filter(p -> closestStation.getDistanceBetweenTwoGeoPoints(lat, lng, p) <= radiusInKilometers)
                .collect(Collectors.toList());
    }
}