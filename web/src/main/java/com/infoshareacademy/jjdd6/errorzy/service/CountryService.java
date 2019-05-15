package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;
import org.hibernate.Hibernate;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CountryService {

    @Inject
    private CountryDao countryDao;

    public List<Object> getAllList() {
        Hibernate.initialize(countryDao.findAll());
        return new ArrayList<>(countryDao.findAll());
    }

    public CountryModel getCountry(String countryName) {
        CountryModel countryModel = countryDao.findByName(countryName);
        return countryModel;
    }
}
