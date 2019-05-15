package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.PlaceDao;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PlaceService {

    @Inject
    private PlaceDao placeDao;

    public List<PlaceModel> getAllList() {
        List<PlaceModel> placeModelList = new ArrayList<>();
        placeDao.findAll().forEach(placeModel -> {
            placeModelList.add(placeModel);
        });
        return placeModelList;
    }

    public List<PlaceModel> getPlaceByCity(String cityName) {
        return placeDao.findByCity(cityName);
    }
}
