package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
public class CountryXmlToDBLoader {
    private static final Logger LOG = LogManager.getLogger(CountrySearch.class);

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

        countrySearch.getMapOfCountries().values().forEach(country -> {

            CountryModel countryModel = new CountryModel(country.getLat(),
                    country.getLng(),
                    country.getCountryName());

            countryDao.save(countryModel);
            LOG.info(countryModel.getCountryName() + ": Added to DB.");

            cityXmlToDBLoader.loadCityModelToDataBase(country, countryModel);
        });

        LOG.info("Loading to DB finished.");
    }
}
