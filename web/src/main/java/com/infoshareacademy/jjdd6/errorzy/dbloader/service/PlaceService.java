package com.infoshareacademy.jjdd6.errorzy.dbloader.service;

import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.PlaceDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.PlaceModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PlaceService {

    @Inject
    private PlaceDao placeDao;

    public List<PlaceModel> getAllList() {
        return new ArrayList<>(placeDao.findAll());
    }

    public List<PlaceModel> getPlaceByCity(String cityName) {
        return placeDao.findByCity(cityName);
    }

    public PlaceModel getPlaceByName(String name) {
        return placeDao.findByName(name);
    }
}
