package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Stateless
@Startup
public class CountrySearch {

    private static final Logger LOG = LogManager.getLogger(CountrySearch.class);
    private XmlUnmarshaller xmlUnmarshaller = new XmlUnmarshaller();
    private List<Country> countries;

    @PostConstruct
    private void init() {
        String path = "/tmp/nextbike-live.xml";
        LOG.info("XML file loading started.");

        countries = xmlUnmarshaller.getMarkersList(path).getCountryList()
                .stream()
                .filter(country -> {
                    if (country != null) {
                        return true;
                    } else {
                        LOG.warn("Empty country object found.");
                        return false;
                    }
                })
                .collect(Collectors.toList());

        LOG.info("XML file loaded.");
    }

    public synchronized List<Country> getCountries() {
        if (countries.size() == 0) {
            init();
        }
        return countries;
    }

    public Map<String, Country> getMapOfCountries() {
        Map<String, Country> countryMap = new TreeMap<>();

        for (Country country : getCountries()) {
            if (!countryMap.containsKey(country.getCountryName())) {
                countryMap.put(country.getCountryName(), country);
            } else {
                String countryName = country.getCountryName();

                List<City> currentCityList = countryMap.get(countryName).getCityList();
                List<City> cityToBeAddedList = country.getCityList();
                Country newCountry = countryMap.get(countryName);
                newCountry.setCityList(mergeCityLists(currentCityList, cityToBeAddedList));

                countryMap.put(countryName, newCountry);
            }
        }
        return countryMap;
    }

    private List<City> mergeCityLists(List<City> oldCityList, List<City> newCityList) {

        return Stream.of(oldCityList, newCityList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
