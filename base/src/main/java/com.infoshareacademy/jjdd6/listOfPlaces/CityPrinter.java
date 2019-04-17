package com.infoshareacademy.jjdd6.listOfPlaces;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CitySearch;

import javax.xml.bind.JAXBException;
import java.util.concurrent.atomic.AtomicInteger;

public class CityPrinter {
    public static void printCityList() throws JAXBException {

        CitySearch citySearch = new CitySearch();
        AtomicInteger index = new AtomicInteger();

        citySearch.getCities()
                .stream()
                .map(m -> m.getName())
                .distinct()
                .sorted()
                .forEach(n -> System.out.println(index.incrementAndGet() + ". " + n));
    }
}


