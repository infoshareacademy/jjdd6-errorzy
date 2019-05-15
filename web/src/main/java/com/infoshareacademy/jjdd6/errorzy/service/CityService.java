package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.CityDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CityService {

    @Inject
    private CityDao cityDao;

    public List<CityModel> getAllList() {
        List<CityModel> cityModelList = cityDao.findAll();
        return cityModelList;
    }

    public CityModel getCity(String cityName) {
        CityModel cityModel = cityDao.findByName(cityName);
        return cityModel;
    }

}
