package com.infoshareacademy.jjdd6.errorzy.dbloader.service.dbloaders;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.PlaceDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.PlaceModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.logging.Logger;

@Stateless
@Transactional
public class PlaceXmlToDBLoader {

    private static final Logger LOGGER = Logger.getLogger(PlaceXmlToDBLoader.class.getName());

    @EJB
    private PlaceDao placeDao;
    @EJB
    private BikeXmlToDBLoader bikeXmlToDBLoader;

    public void loadPlaceModelToDataBase(City city, CityModel cityModel) {

        if (city.getPlaceList() != null) {
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
}
