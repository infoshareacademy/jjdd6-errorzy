package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@Singleton
@Startup
public class XmlToDbLoader {

    Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private CountryDao countryDao;
    @Inject
    private CountrySearch countrySearch;

    @Schedule(hour = "*", minute = "*/5", second = "*")
    public void loadCountriesToDB() {
        logger.info("hello from scheduler");
        List<Country> countryList = countrySearch.getCountries();
        countryList.forEach(country -> countryDao.save(country));
    }
}
