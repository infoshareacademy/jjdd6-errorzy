package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.transaction.Transactional;
import java.util.logging.Logger;

@Singleton
@Transactional
public class CountryXmlToDBLoader {
    private static final Logger LOGGER = Logger.getLogger(CountryXmlToDBLoader.class.getName());

    @EJB
    private CountryDao countryDao;
    @EJB
    private CountrySearch countrySearch;
    @EJB
    private CityXmlToDBLoader cityXmlToDBLoader;

    public void loadCountryModelAtStart() {
        loadCountryModelToDataBase();
    }

    private void loadCountryModelToDataBase() {
        countrySearch.getCountries().forEach(country -> {

            CountryModel countryModel = countryDao.findByName(country.getCountryName());

            if (countryModel == null) {
                countryModel = new CountryModel(country.getLat(),
                        country.getLng(),
                        country.getCountryName());

                countryDao.save(countryModel);
                LOGGER.info(countryModel.getCountryName() + ": Added to DB.");
            } else {
                LOGGER.info(countryModel.getCountryName() + ": Already exists in the DB.");
            }


            cityXmlToDBLoader.loadCityModelToDataBase(country, countryModel);
        });
        LOGGER.info(": Loading to DB finished.");
    }
}
