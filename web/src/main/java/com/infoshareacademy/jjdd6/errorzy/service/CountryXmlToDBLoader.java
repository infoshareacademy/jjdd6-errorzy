package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class CountryXmlToDBLoader {

    @Inject
    private CountryDao countryDao;
    @Inject
    private CountrySearch countrySearch;
    @Inject
    private CityXmlToDBLoader cityXmlToDBLoader;

    @PostConstruct
    public void loadCountryXmlToDataBase() {
        countrySearch.getMapOfCountries().values().forEach(country -> {
            CountryModel countryModel = new CountryModel(country.getLat(),
                    country.getLng(),
                    country.getCountryName());
            countryDao.save(countryModel);

            cityXmlToDBLoader.prepareCityModelList(countryModel);
        });
    }
}
