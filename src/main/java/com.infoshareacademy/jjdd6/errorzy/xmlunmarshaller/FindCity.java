package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.Country;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.stream.Collectors;

public class FindCity {


    private FindCountry findCountry = new FindCountry();

    private List<Country> getCities() throws JAXBException {

        return findCountry.getCountries()
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
