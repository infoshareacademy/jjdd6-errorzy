package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.PlaceDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.PlaceSearch;

import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class PlaceXmlToDBLoader {

    @Inject
    private PlaceDao placeDao;
    @Inject
    private PlaceSearch placeSearch;
    @Inject
    private BikeXmlToDBLoader bikeXmlToDBLoader;

//    private void loadPlaceXmlToDataBase() {
//        preparePlaceModelList();
//    }

    public void preparePlaceModelList(CityModel cityModel) {
        placeSearch.getMapOfPlaces(cityModel.getName()).values().forEach(place -> {
            PlaceModel placeModel = new PlaceModel(place.getLat(),
                    place.getLng(),
                    place.getName(),
                    place.getNumber(),
                    cityModel);
            placeDao.save(placeModel);

            bikeXmlToDBLoader.loadBikeModelToDB(placeModel);
        });
    }
}
