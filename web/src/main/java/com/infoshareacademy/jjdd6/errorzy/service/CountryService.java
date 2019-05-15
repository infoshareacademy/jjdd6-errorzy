package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CountryService {

    @Inject
    CountryDao countryDao;

    public List<CountryModel> getAllList() {
        List<CountryModel> countryModelList = countryDao.findAll();
        return countryModelList;
    }

    public CountryModel getCountry(String countryName) {
        CountryModel countryModel = countryDao.findByName(countryName);
        return countryModel;
    }
}
