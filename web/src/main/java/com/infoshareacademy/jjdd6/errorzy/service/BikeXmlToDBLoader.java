package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.BikeDao;
import com.infoshareacademy.jjdd6.errorzy.model.BikeModel;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.BikeSearch;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.logging.Logger;

@Singleton
public class BikeXmlToDBLoader {
    private static final Logger LOGGER = Logger.getLogger(BikeXmlToDBLoader.class.getName());

    @Inject
    private BikeDao bikeDao;
    @Inject
    private BikeSearch bikeSearch;

    public void loadBikeModelToDataBase(PlaceModel placeModel) {
        bikeSearch.getMapOfBikesForPlace(placeModel.getName()).values()
                .forEach(bike -> {
                    BikeModel bikeModel = new BikeModel(bike.getNumber(),
                            bike.getBikeType(),
                            placeModel);
                    bikeDao.save(bikeModel);
                });
    }
}
