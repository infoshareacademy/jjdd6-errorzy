package com.infoshareacademy.jjdd6.errorzy.dbloader.service;

import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CountryModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Transactional
public class CountryService {

    @Inject
    private CountryDao countryDao;

    public List<Object> getAllList() {
        return new ArrayList<>(countryDao.findAll());
    }

    public CountryModel getCountry(String countryName) {
        CountryModel countryModel = countryDao.findByName(countryName);
        return countryModel;
    }
}
