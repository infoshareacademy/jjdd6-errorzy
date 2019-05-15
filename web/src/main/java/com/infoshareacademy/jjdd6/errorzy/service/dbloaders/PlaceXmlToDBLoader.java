package com.infoshareacademy.jjdd6.errorzy.service.dbloaders;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.dao.PlaceDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
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

//                if (place.getBikeList() != null) {
//                    LOGGER.info("Saving " + place.getBikeList().size() + " bikes");
//                }
                bikeXmlToDBLoader.loadBikeModelToDataBase(place, placeModel);
            });
        }
    }
}
