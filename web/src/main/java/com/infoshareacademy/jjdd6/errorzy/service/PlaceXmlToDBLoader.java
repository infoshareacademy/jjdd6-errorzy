package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.PlaceDao;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.PlaceSearch;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class PlaceXmlToDBLoader {

    @Inject
    private PlaceDao placeDao;
    @Inject
    private PlaceSearch placeSearch;
    @Inject
    private BikeXmlToDBLoader bikeXmlToDBLoader;


    @PostConstruct
    private void loadPlaceXmlToDataBase() {
        preparePlaceModelList();
    }

    public void preparePlaceModelList() {
        placeSearch.getPlaces().forEach(place -> {
            PlaceModel placeModel = new PlaceModel(place.getLat(),
                    place.getLng(),
                    place.getName(),
                    place.getNumber());
            placeDao.save(placeModel);

            bikeXmlToDBLoader.prepareBikeModelList(placeModel);
        });
    }
}
