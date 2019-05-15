package com.infoshareacademy.jjdd6.errorzy.dbloader.service;

import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.CityDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CityModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CityService {

    @Inject
    private CityDao cityDao;

    public List<CityModel> getAllList() {
        return new ArrayList<>(cityDao.findAll());
    }

    public List<CityModel> getCitiesByCountry(String countryName) {
        return cityDao.findByCountry(countryName);
    }
}
