package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Stateless
public class CitySearch {
private static final Logger LOG = LogManager.getLogger(CitySearch.class);
    private CountrySearch findCountry = new CountrySearch();

    public List<City> getCities() {
        LOG.info("List of all cities has been created.");
        return findCountry.getCountries()
                .stream()
                .map(Country::getCityList)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    private List<City> getCitiesForCountry(String countryName) {
        LOG.info("List of cities of: " + countryName + " has been created.");
        return findCountry.getCountries().stream()
                .filter(x -> x.getCountryName().equals(countryName))
                .flatMap(c -> c.getCityList().stream())
                .collect(Collectors.toList());
    }

    public Map<String, City> getMapOfCitiesForCountry(String countryName) {
        LOG.info("Map of country: " + countryName + " has been created.");
        Map<String, City> cityMap = new TreeMap<>();

        for (City city : getCitiesForCountry(countryName)) {
            if (!cityMap.containsKey(city.getName())) {
                cityMap.put(city.getName(), city);
            }
        }
        return cityMap;
    }
}
