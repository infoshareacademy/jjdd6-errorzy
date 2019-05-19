package com.infoshareacademy.jjdd6.errorzy.dbloader.service.dbloaders;

import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.XmlUnmarshaller;
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
    private static final String path = "/tmp/nextbike-live.xml";

    @EJB
    private CountryDao countryDao;
    @EJB
    private CountrySearch countrySearch;
    @EJB
    private CityXmlToDBLoader cityXmlToDBLoader;
    @EJB
    private XmlUnmarshaller xmlUnmarshaller;

    public void loadCountryModelAtStart() {
        LOGGER.info("Loading to database started.");
        loadCountryModelToDataBase();
    }

    private void loadCountryModelToDataBase() {

        xmlUnmarshaller.getMarkersList(path).getCountryList().forEach(country -> {

            CountryModel countryModel = new CountryModel(country.getLat(),
                    country.getLng(),
                    country.getCountryName());

            CountryModel countryModelToBePassed = countryDao.findByName(countryModel.getCountryName());

            if (countryModelToBePassed == null) {
                countryDao.save(countryModel);
                LOGGER.info(country.getCountryName() + ": Added to DB.");

            } else {

                LOGGER.info(country.getCountryName() + " is already in database.");
            }

            LOGGER.info("Saving " + country.getCityList().size() + " cities");
            cityXmlToDBLoader.loadCityModelToDataBase(country, countryModelToBePassed);
        });
        LOGGER.info("Loading to DB finished.");
    }
}
