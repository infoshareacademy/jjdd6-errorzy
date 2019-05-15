package com.infoshareacademy.jjdd6.errorzy.service.dbloaders;

import com.infoshareacademy.jjdd6.errorzy.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.logging.Logger;

@Stateless
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
        LOGGER.info("Loading to database started.");
        loadCountryModelToDataBase();
    }

    private void loadCountryModelToDataBase() {

        countrySearch.getMapOfCountries().values().forEach(country -> {

            CountryModel countryModel = new CountryModel(country.getLat(),
                    country.getLng(),
                    country.getCountryName());

            countryDao.save(countryModel);
            LOGGER.info(countryModel.getCountryName() + ": Added to DB.");

            cityXmlToDBLoader.loadCityModelToDataBase(country, countryModel);
        });

        LOGGER.info("Loading to DB finished.");
    }
}
