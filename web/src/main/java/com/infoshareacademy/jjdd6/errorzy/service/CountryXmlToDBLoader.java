package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Logger;

@Singleton
@Startup
public class CountryXmlToDBLoader {
    private static final Logger LOGGER = Logger.getLogger(CountryXmlToDBLoader.class.getName());

    @Inject
    private CountryDao countryDao;
    @Inject
    private CountrySearch countrySearch;
    @Inject
    private CityXmlToDBLoader cityXmlToDBLoader;

    @PostConstruct
    public void loadCountryModelAtStart() {
        Runnable task = this::loadCountryModelToDataBase;
        new Thread(task).start();
    }

    private void loadCountryModelToDataBase() {
        countrySearch.getMapOfCountries().values().forEach(country -> {
            CountryModel countryModel = new CountryModel(country.getLat(),
                    country.getLng(),
                    country.getCountryName());
            countryDao.save(countryModel);
            LOGGER.info(countryModel.getCountryName() + ": Added to DB.");
            cityXmlToDBLoader.loadCityModelToDataBase(countryModel);
        });
    }
}
