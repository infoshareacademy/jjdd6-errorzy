package com.infoshareacademy.jjdd6.listOfPlaces;

import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.FindCity;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.FindCountry;

import javax.xml.bind.JAXBException;
import java.util.concurrent.atomic.AtomicInteger;

public class ListOfCities {
    public static void run() throws JAXBException {

        FindCity findCity = new FindCity();
        AtomicInteger index = new AtomicInteger();

        findCity.getCities()
                .stream()
                .map(m -> m.getName())
                .distinct()
                .sorted()
                .forEach(n -> System.out.println(index.incrementAndGet() + ". " + n));

    }
}


