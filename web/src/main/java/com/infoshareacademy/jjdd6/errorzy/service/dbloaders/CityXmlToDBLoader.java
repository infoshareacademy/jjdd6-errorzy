package com.infoshareacademy.jjdd6.errorzy.service.dbloaders;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.dao.CityDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;
import org.jboss.ejb3.annotation.TransactionTimeout;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Stateless
@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
@TransactionTimeout(value=30, unit=TimeUnit.MINUTES)
public class CityXmlToDBLoader {
    private static final Logger LOGGER = Logger.getLogger(CityXmlToDBLoader.class.getName());

    @EJB
    private CityDao cityDao;
    @EJB
    private PlaceXmlToDBLoader placeXmlToDBLoader;

    public void loadCityModelToDataBase(Country country, CountryModel countryModel) {

        if (country.getCityList() != null) {
            country.getCityList().stream().forEach(city -> {

                CityModel cityModel = new CityModel(city.getLat(),
                        city.getLng(),
                        city.getName(),
                        countryModel);

                cityDao.save(cityModel);

                //LOGGER.info("Saving " + city.getPlaceList().size() + " places");
                placeXmlToDBLoader.loadPlaceModelToDataBase(city, cityModel);
            });
        }
    }
}
