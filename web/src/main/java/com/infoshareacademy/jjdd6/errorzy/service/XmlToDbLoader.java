package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

import static java.util.stream.Collectors.toList;

@Singleton
@Startup
public class XmlToDbLoader {

    Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private CountryDao countryDao;
    @Inject
    private CountrySearch countrySearch;

    @Schedule(hour = "*", minute = "*/1", second = "*")
    public void loadCountriesToDB() {
        logger.info("hello from scheduler");
        List<Country> countryList = countrySearch.getCountries()
                .stream()
                .map(country -> new CountryModel(
                        country.getCityList()
                        .stream()
                        .map(city -> {
                          return new CityModel()
                        }),
                        country.getLat(),
                        country.getLng(),
                        country.getCountryName()
                ))
                .collect(toList());
        countryList.forEach(country -> countryDao.save(country));
    }
}
