package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.dao.CityDao;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CitySearch;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.List;

@Singleton
public class CityXmlToDBLoader {

    @Inject
    private CityDao cityDao;
    @Inject
    private CitySearch citySearch;

    public void loadCityXmlToDataBase(String placeName) {
        List<City> cityList = citySearch.getCities();
        cityList.forEach(city -> cityDao.save(city));
    }
}
