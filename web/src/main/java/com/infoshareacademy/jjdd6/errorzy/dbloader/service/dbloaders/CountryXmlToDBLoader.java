package com.infoshareacademy.jjdd6.errorzy.dbloader.service.dbloaders;

import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;
import org.jboss.ejb3.annotation.TransactionTimeout;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.transaction.Transactional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Stateless
@Transactional
@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
@TransactionTimeout(value = 30, unit = TimeUnit.MINUTES)
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

            LOGGER.info("Saving " + country.getCityList().size() + " cities");
            cityXmlToDBLoader.loadCityModelToDataBase(country, countryModel);
        });

        LOGGER.info("Loading to DB finished.");
    }
}
