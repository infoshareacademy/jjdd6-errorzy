package com.infoshareacademy.jjdd6.errorzy.dbloader.service.dbloaders;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.BikeDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.BikeModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.PlaceModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
@Transactional
public class BikeXmlToDBLoader {

    @EJB
    private BikeDao bikeDao;

    public void loadBikeModelToDataBase(Place place, PlaceModel placeModel) {

        if (place.getBikeList() != null) {
            place.getBikeList().forEach(bike -> {

                BikeModel bikeModel = new BikeModel(bike.getNumber(),
                        bike.getBikeType(),
                        placeModel);
                bikeDao.save(bikeModel);
            });
        }
    }
}
