package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.Bike;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Stateless
public class BikeSearch {
    private static final Logger LOG = LogManager.getLogger(BikeSearch.class);
    private PlaceSearch placeSearch = new PlaceSearch();

    public Map<String, Bike> getMapOfBikesForPlace(String placeName) {
        LOG.info("Bikes in place: " + placeName + " generated.");
        return placeSearch.getPlaces().stream()
                .filter(place -> place.getName().equals(placeName))
                .map(place -> place.getBikeList().stream())
                .flatMap(bikeStream -> bikeStream)
                .collect(Collectors.toMap((key -> String.valueOf(key.getNumber())), Function.identity()));
    }
}
