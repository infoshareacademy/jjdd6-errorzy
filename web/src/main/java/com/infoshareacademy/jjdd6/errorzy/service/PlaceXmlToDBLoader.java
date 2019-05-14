package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.dao.PlaceDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.PlaceSearch;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.logging.Logger;

@Singleton
public class PlaceXmlToDBLoader {

    private static final Logger LOGGER = Logger.getLogger(PlaceXmlToDBLoader.class.getName());

    @EJB
    private PlaceDao placeDao;
    @EJB
    private BikeXmlToDBLoader bikeXmlToDBLoader;

    public void loadPlaceModelToDataBase(City city, CityModel cityModel) {
        city.getPlaceList().forEach(place -> {

            PlaceModel placeModel = new PlaceModel(place.getLat(),
                    place.getLng(),
                    place.getName(),
                    place.getNumber(),
                    cityModel);
            placeDao.save(placeModel);

            bikeXmlToDBLoader.loadBikeModelToDataBase(place, placeModel);
        });
    }
}
