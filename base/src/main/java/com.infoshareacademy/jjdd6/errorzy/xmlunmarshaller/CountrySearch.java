package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;

import javax.ejb.Singleton;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Singleton
public class CountrySearch {

    private static final Logger LOGGER = Logger.getLogger(CountrySearch.class.getName());

    private XmlUnmarshaller xmlUnmarshaller = new XmlUnmarshaller();

    private List<Country> countries = new ArrayList<>();

    private void init() {
        LOGGER.info("LADUJE DANE Z PLIKU");

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
