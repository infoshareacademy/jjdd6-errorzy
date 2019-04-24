package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.Country;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Stateless
public class CountrySearch {

    private XmlUnmarshaller xmlUnmarshaller = new XmlUnmarshaller();

    public List<Country> getCountries() {

        String path = this.getClass().getResource("/tmp/nextbike-live.xml").getPath();
        return xmlUnmarshaller.getMarkersList(path).getCountryList()
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, Country> getMapOfCountries() {
        Map<String, Country> countryMap = new TreeMap<>();

        for (Country country : getCountries()) {
            if (!countryMap.containsKey(country.getCountryName())) {
                countryMap.put(country.getCountryName(), country);
            }
        }
        return countryMap;
    }
}
