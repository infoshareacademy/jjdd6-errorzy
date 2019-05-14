package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.Bike;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Stateless
public class BikeSearch {
    private static final Logger LOG = LogManager.getLogger(BikeSearch.class);

    @Inject
    private PlaceSearch placeSearch;

    public Map<String, Bike> getMapOfBikesForPlace(String placeName) {
        LOG.info("Bikes in place: " + placeName + " generated.");
        return placeSearch.getPlaces().stream()
                .filter(Objects::nonNull)
                .filter(place -> place.getName().equals(placeName))
                .filter(place -> place.getBikeList() != null)
                .map(place -> place.getBikeList().stream())
                .flatMap(bikeStream -> bikeStream)
                .filter(Objects::nonNull)
                .collect(Collectors.toMap((key -> String.valueOf(key.getNumber())), Function.identity()));
    }
}
