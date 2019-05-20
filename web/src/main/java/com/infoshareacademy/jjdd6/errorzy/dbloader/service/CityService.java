package com.infoshareacademy.jjdd6.errorzy.dbloader.service;

import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.CityDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CityModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Transactional
public class CityService {
    private static final Logger LOG = LogManager.getLogger(CityService.class);

    @Inject
    private CityDao cityDao;

    public List<CityModel> getAllList() {
        LOG.info("List of all cities method called.");
        return new ArrayList<>(cityDao.findAll());
    }

    public List<CityModel> getCitiesByCountry(String countryName) {
        LOG.info("List of all cities by country method called.");
        return cityDao.findByCountry(countryName);
    }
}
