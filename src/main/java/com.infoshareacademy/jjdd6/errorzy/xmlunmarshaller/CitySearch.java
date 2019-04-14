package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CitySearch {

    private CountrySearch findCountry = new CountrySearch();

    public List<City> getCities() throws JAXBException {

        return findCountry.getCountries()
                .stream()
                .map(country -> country.getCityList())
                .flatMap(list -> list.stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<City> getCitiesForCountry(String countryName) throws JAXBException {
        return findCountry.getCountries().stream()
                .filter(x -> x.getCountryName().equals(countryName))
                .flatMap(c -> c.getCityList().stream())
                .collect(Collectors.toList());
    }

    public Map<String, City> getMapOfCitiesForCountry(String countryName) throws JAXBException {
        Map<String, City> cityMap = new TreeMap<>();

        for (City city : getCitiesForCountry(countryName)) {
            if (!cityMap.containsKey(city.getName())) {
                cityMap.put(city.getName(), city);
            }
        }
        return cityMap;
    }
}
