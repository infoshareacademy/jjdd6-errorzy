package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.CityDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CitySearch;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.logging.Logger;

@Singleton
public class CityXmlToDBLoader {
    private static final Logger LOGGER = Logger.getLogger(CityXmlToDBLoader.class.getName());

    @Inject
    private CityDao cityDao;
    @Inject
    private CitySearch citySearch;
    @Inject
    private PlaceXmlToDBLoader placeXmlToDBLoader;

    public void loadCityModelToDataBase(CountryModel countryModel) {
        citySearch.getMapOfCitiesForCountry(countryModel.getCountryName()).values().forEach(city -> {
            CityModel cityModel = new CityModel(city.getLat(),
                    city.getLng(),
                    city.getName(),
                    countryModel);
            cityDao.save(cityModel);
LOGGER.info(cityModel.getName() + ": City added to DB.");
            placeXmlToDBLoader.loadPlaceModelToDataBase(cityModel);
        });

    }
}
