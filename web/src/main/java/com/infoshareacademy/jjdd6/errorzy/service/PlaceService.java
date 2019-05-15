package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.PlaceDao;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PlaceService {

    @Inject
    private PlaceDao placeDao;

    public List<PlaceModel> getAllList() {
        List<PlaceModel> placeModelList = placeDao.findAll();
        return placeModelList;
    }

    public PlaceModel getPlace(String placeName) {
        PlaceModel placeModel = placeDao.findByName(placeName);
        return placeModel;
    }

}
