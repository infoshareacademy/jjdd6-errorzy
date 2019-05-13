package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.dao.BikeDao;
import com.infoshareacademy.jjdd6.errorzy.model.BikeModel;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.BikeSearch;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.logging.Logger;

@Singleton
public class BikeXmlToDBLoader {
    private static final Logger LOGGER = Logger.getLogger(BikeXmlToDBLoader.class.getName());

    @EJB
    private BikeDao bikeDao;
    @EJB
    private BikeSearch bikeSearch;

    public void loadBikeModelToDataBase(Place place, PlaceModel placeModel) {
        if (place.getBikeList() != null) {
            place.getBikeList().stream().forEach(bike -> {

                BikeModel bikeModel = new BikeModel(bike.getNumber(),
                        bike.getBikeType(),
                        placeModel);
                bikeDao.save(bikeModel);
            });
        }
    }
}
