package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.BikeDao;
import com.infoshareacademy.jjdd6.errorzy.model.BikeModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BikeService {

    @Inject
    private BikeDao bikeDao;

    public List<BikeModel> getAllList() {
        return bikeDao.findAll();
    }
}
