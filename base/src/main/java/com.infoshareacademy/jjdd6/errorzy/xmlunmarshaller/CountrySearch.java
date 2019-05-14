package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

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
        return xmlUnmarshaller.getMarkersList(path).getCountryList()
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, Country> getMapOfCountries() {
        LOG.info("Get map of countries method has been called");
        Map<String, Country> countryMap = new TreeMap<>();

        for (Country country : getCountries()) {
            if (!countryMap.containsKey(country.getCountryName())) {
                countryMap.put(country.getCountryName(), country);
            }
        }
        return countryMap;
    }
}
