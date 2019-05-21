package com.infoshareacademy.jjdd6.errorzy.dbloader.service;

import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CountryModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Transactional
public class CountryService {
    private static final Logger LOG = LogManager.getLogger(CountryService.class);

    @Inject
    private CountryDao countryDao;

    public List<CountryModel> getAllList() {
        LOG.info("List of all countries method called.");
        return new ArrayList<>(countryDao.findAll());
    }

    public CountryModel getCountry(String countryName) {
        CountryModel countryModel = countryDao.findByName(countryName);
        return countryModel;
    }
}
