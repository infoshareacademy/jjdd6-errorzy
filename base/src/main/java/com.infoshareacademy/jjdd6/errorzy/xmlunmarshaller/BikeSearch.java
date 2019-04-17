package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.Bike;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.stream.Collectors;

public class BikeSearch {
private PlaceSearch placeSearch = new PlaceSearch();

    public List<Bike> getBikesForPlace(String placeName) throws JAXBException {
        return placeSearch.getPlacesForCity(placeName).stream()
                .filter(x -> x.getName().equals(placeName))
                .flatMap(c -> c.getBikeList().stream())
                .collect(Collectors.toList());
    }
}
