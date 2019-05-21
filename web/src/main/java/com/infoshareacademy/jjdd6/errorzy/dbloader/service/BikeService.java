package com.infoshareacademy.jjdd6.errorzy.dbloader.service;

import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.BikeDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.BikeModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@Transactional
public class BikeService {
    private static final Logger LOG = LogManager.getLogger(BikeService.class);

    @Inject
    private BikeDao bikeDao;

    public List<BikeModel> getAllList() {
        LOG.info("List of all bikes generated.");
        return bikeDao.findAll();
    }

    public List<BikeModel> getAllBikesForPlace(String placeName) {
        LOG.info("List of bikes in a specific places generated.");
        return bikeDao.findByPlace(placeName);
    }
}
