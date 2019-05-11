package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.CityDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CitySearch;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class CityXmlToDBLoader {

    @Inject
    private CityDao cityDao;
    @Inject
    private CitySearch citySearch;
    @Inject
    private PlaceXmlToDBLoader placeXmlToDBLoader;

//    @PostConstruct
//    private void loadCityXmlToDataBase() {
//        prepareCityModelList();
//    }

    public void prepareCityModelList(CountryModel countryModel) {
        citySearch.getMapOfCitiesForCountry(countryModel.getCountryName()).values().forEach(city -> {
            CityModel cityModel = new CityModel(city.getLat(),
                    city.getLng(),
                    city.getName(),
                    countryModel);
            cityDao.save(cityModel);

            placeXmlToDBLoader.preparePlaceModelList(cityModel);
        });

    }
}
