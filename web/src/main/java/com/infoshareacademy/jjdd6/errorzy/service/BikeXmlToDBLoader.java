package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.dao.BikeDao;
import com.infoshareacademy.jjdd6.errorzy.model.BikeModel;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BikeXmlToDBLoader {

    @EJB
    private BikeDao bikeDao;

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
