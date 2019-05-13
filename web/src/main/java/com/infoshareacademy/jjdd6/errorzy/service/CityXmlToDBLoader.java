package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.dao.CityDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CitySearch;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class CityXmlToDBLoader {
    private static final Logger LOG = LogManager.getLogger(CountrySearch.class);

    @EJB
    private CityDao cityDao;
    @EJB
    private CitySearch citySearch;
    @EJB
    private PlaceXmlToDBLoader placeXmlToDBLoader;

    public void loadCityModelToDataBase(Country country, CountryModel countryModel) {
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
