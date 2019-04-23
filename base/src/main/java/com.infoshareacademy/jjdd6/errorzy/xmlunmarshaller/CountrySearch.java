package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.Country;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CountrySearch {

    private XmlUnmarshaller xmlUnmarshaller = new XmlUnmarshaller();

    public List<Country> getCountries() throws JAXBException {

        return xmlUnmarshaller.getMarkersList().getCountryList()
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, Country> getMapOfCountries() throws JAXBException {
        Map<String, Country> countryMap = new TreeMap<>();

        for (Country country : getCountries()) {
            if (!countryMap.containsKey(country.getCountryName())) {
                countryMap.put(country.getCountryName(), country);
            }
        }
        return countryMap;
    }
}
