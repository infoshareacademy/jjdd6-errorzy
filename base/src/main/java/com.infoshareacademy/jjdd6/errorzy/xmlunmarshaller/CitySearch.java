package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;

import javax.ejb.Stateless;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Stateless
public class CitySearch {

    private CountrySearch findCountry = new CountrySearch();

    public List<City> getCities() {
        return findCountry.getCountries()
                .stream()
                .map(Country::getCityList)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    private List<City> getCitiesForCountry(String countryName) {
        return findCountry.getCountries().stream()
                .filter(x -> x.getCountryName().equals(countryName))
                .flatMap(c -> c.getCityList().stream())
                .collect(Collectors.toList());
    }

    public Map<String, City> getMapOfCitiesForCountry(String countryName) {
        Map<String, City> cityMap = new TreeMap<>();

        for (City city : getCitiesForCountry(countryName)) {
            if (!cityMap.containsKey(city.getName())) {
                cityMap.put(city.getName(), city);
            }
        }
        return cityMap;
    }
}
