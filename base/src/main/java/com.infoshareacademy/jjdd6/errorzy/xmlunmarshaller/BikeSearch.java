package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.Bike;

import javax.ejb.Stateless;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Stateless
public class BikeSearch {

    private PlaceSearch placeSearch = new PlaceSearch();

    public Map<String, Bike> getMapOfBikesForPlace(String placeName) {
        return placeSearch.getPlaces().stream()
                .filter(Objects::nonNull)
                .filter(place -> place.getName().equals(placeName))
                .map(place -> place.getBikeList().stream())
                .flatMap(bikeStream -> bikeStream)
                .filter(Objects::nonNull)
                .collect(Collectors.toMap((key -> String.valueOf(key.getNumber())), Function.identity()));
    }
}
