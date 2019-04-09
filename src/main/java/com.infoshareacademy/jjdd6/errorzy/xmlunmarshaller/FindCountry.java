package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.Country;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.stream.Collectors;

public class FindCountry {

    private XmlUnmarshaller xmlUnmarshaller = new XmlUnmarshaller();

    public List<Country> getCountries() throws JAXBException {

        return xmlUnmarshaller.getMarkerlist().getCountryList()
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
