package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.PlaceDao;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.PlaceSearch;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@Startup
public class PlaceXmlToDBLoader {

    @Inject
    private PlaceDao placeDao;
    @Inject
    private PlaceSearch placeSearch;
    @Inject
    private BikeXmlToDBLoader bikeXmlToDBLoader;

    @Schedule(hour = "*/1", minute = "*", second = "*")
    public void loadPlaceXmlToDataBase() {

        List<PlaceModel> placeModelList = placeSearch.getPlaces().stream()
                .map(place -> new PlaceModel(place.getLat(),
                        place.getLng(),
                        place.getName(),
                        place.getNumber(),
                        bikeXmlToDBLoader.prepareBikeModelList(place.getName())))
                .collect(Collectors.toList());

        placeModelList.forEach(placeModel -> placeDao.save(placeModel));
    }
}
