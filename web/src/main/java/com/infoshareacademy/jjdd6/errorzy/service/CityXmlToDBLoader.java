package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.dao.CityDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class CityXmlToDBLoader {
    private static final Logger LOGGER = Logger.getLogger(CityXmlToDBLoader.class.getName());

    @EJB
    private CityDao cityDao;
    @EJB
    private PlaceXmlToDBLoader placeXmlToDBLoader;

    public void loadCityModelToDataBase(Country country, CountryModel countryModel) {

        if (country.getCityList() != null) {
            country.getCityList().stream().forEach(city -> {

                CityModel cityModel = new CityModel(city.getLat(),
                        city.getLng(),
                        city.getName(),
                        countryModel);

                cityDao.save(cityModel);

                placeXmlToDBLoader.loadPlaceModelToDataBase(city, cityModel);
            });
        }
    }
}
