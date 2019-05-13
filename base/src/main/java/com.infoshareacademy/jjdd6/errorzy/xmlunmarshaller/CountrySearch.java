package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Stateless
public class CountrySearch {

    private static final Logger LOG = LogManager.getLogger(CountrySearch.class);

    private XmlUnmarshaller xmlUnmarshaller = new XmlUnmarshaller();

    public List<Country> getCountries() {
        LOG.info("Countries from xml-file has been loaded");
        String path = "/tmp/nextbike-live.xml";
        countries = xmlUnmarshaller.getMarkersList(path).getCountryList()
                .stream()
                .filter(country -> {
                    if (country != null) {
                        return true;
                    } else {
                        LOGGER.info("----------------------------------- Empty country !!! -----------------------------------");
                        return false;
                    }
                })
                .collect(Collectors.toList());

        countries.forEach(System.out::println);

        LOGGER.info("KONIEC LADOWANIA");
    }

    public synchronized List<Country> getCountries() {
        if (countries.size() == 0) {
            init();
        }
        return countries;
    }

    public Map<String, Country> getMapOfCountries() {
        LOG.info("Get map of countries method has been called");
        Map<String, Country> countryMap = new TreeMap<>();

        for (Country country : getCountries()) {
            if (!countryMap.containsKey(country.getCountryName())) {
                countryMap.put(country.getCountryName(), country);
            } else {
                List<City> oldCityList = countryMap.get(country.getCountryName()).getCityList();
                countryMap.get(country.getCountryName()).setCityList(mergeTwoCityLists(country, oldCityList));



            }
        }
        return countryMap;
    }

    private List<City> mergeTwoCityLists(Country country, List<City> oldCityList) {
        return Stream.of(oldCityList, country.getCityList())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

}
