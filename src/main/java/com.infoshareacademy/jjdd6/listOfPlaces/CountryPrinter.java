package com.infoshareacademy.jjdd6.listOfPlaces;


import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;

import javax.xml.bind.JAXBException;
import java.util.concurrent.atomic.AtomicInteger;

public class CountryPrinter {


    public static void printCountryList() throws JAXBException {
        CountrySearch countrySearch = new CountrySearch();
        AtomicInteger index = new AtomicInteger();

        countrySearch
                .getCountries()
                .stream()
                .map(m -> m.getCountryName())
                .distinct()
                .sorted()
                .forEach(n -> System.out.println(index.incrementAndGet() + ". " + n));


    }
}
