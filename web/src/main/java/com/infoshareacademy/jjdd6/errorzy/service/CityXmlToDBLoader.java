package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.dao.CityDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CitySearch;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.logging.Logger;

@Singleton
public class CityXmlToDBLoader {
    private static final Logger LOGGER = Logger.getLogger(CityXmlToDBLoader.class.getName());

    @EJB
    private CityDao cityDao;
    @EJB
    private CitySearch citySearch;
    @EJB
    private PlaceXmlToDBLoader placeXmlToDBLoader;

    public void loadCityModelToDataBase(Country country, CountryModel countryModel) {
        country.getCityList().stream().forEach(city -> {
            CityModel cityModel = cityDao.findByName(city.getName());

            if (cityModel == null) {
                cityModel = new CityModel(city.getLat(),
                        city.getLng(),
                        city.getName(),
                        countryModel);

                cityDao.save(cityModel);
            }

            placeXmlToDBLoader.loadPlaceModelToDataBase(city, cityModel);
        });

//        citySearch.getMapOfCitiesForCountry(countryModel.getCountryName()).values().forEach(city -> {
//            CityModel cityModel = new CityModel(city.getLat(),
//                    city.getLng(),
//                    city.getName(),
//                    countryModel);
//            cityDao.save(cityModel);
//
//            placeXmlToDBLoader.loadPlaceModelToDataBase(cityModel);
//        });

    }
}
