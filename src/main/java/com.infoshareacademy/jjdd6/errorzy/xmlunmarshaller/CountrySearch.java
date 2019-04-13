package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.Country;

import javax.xml.bind.JAXBException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountrySearch {

    private XmlUnmarshaller xmlUnmarshaller = new XmlUnmarshaller();

    public List<Country> getCountries() throws JAXBException {

        return xmlUnmarshaller.getMarkerlist().getCountryList()
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, Country> getMapOfCountries() throws JAXBException {
        return getCountries().stream()
                .collect(Collectors.toMap(Country::getCountryName, country -> country));
    }
}
