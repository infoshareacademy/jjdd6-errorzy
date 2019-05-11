package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.PlaceDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.PlaceSearch;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.logging.Logger;

@Singleton
public class PlaceXmlToDBLoader {

    private static final Logger LOGGER = Logger.getLogger(PlaceXmlToDBLoader.class.getName());

    @Inject
    private PlaceDao placeDao;
    @Inject
    private PlaceSearch placeSearch;
    @Inject
    private BikeXmlToDBLoader bikeXmlToDBLoader;

    public void loadPlaceModelToDataBase(CityModel cityModel) {
        placeSearch.getMapOfPlaces(cityModel.getName()).values().forEach(place -> {
            PlaceModel placeModel = new PlaceModel(place.getLat(),
                    place.getLng(),
                    place.getName(),
                    place.getNumber(),
                    cityModel);
            placeDao.save(placeModel);

            LOGGER.info(placeModel.getName() + ": place added to DB.");

            bikeXmlToDBLoader.loadBikeModelToDataBase(placeModel);
        });
    }
}
