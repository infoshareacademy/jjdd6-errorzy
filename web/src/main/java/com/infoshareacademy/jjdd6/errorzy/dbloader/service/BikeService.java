package com.infoshareacademy.jjdd6.errorzy.dbloader.service;

import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.BikeDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.BikeModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@Transactional
public class BikeService {

    @Inject
    private BikeDao bikeDao;

    public List<BikeModel> getAllList() {
        return bikeDao.findAll();
    }

    public List<BikeModel> getAllBikesForPlace(String placeName) {
        return bikeDao.findByPlace(placeName);
    }
}
