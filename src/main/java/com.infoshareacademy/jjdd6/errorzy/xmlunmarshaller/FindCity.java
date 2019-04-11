package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.stream.Collectors;

public class FindCity {

    private FindCountry findCountry = new FindCountry();

    public List<City> getCities() throws JAXBException {

        return findCountry.getCountries()
                .stream()
                .map(country -> country.getCityList())
                .flatMap(list -> list.stream())
                .distinct()
                .collect(Collectors.toList());
    }
}
