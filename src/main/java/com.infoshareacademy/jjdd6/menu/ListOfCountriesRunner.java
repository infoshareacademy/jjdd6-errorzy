package com.infoshareacademy.jjdd6.menu;


import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.FindCountry;

import javax.xml.bind.JAXBException;
import java.util.concurrent.atomic.AtomicInteger;

public class ListOfCountriesRunner {


    public static void run() throws JAXBException {
        FindCountry findCountry = new FindCountry();
        AtomicInteger index = new AtomicInteger();

        findCountry
                .getCountries()
                .stream()
                .map(m -> m.getCountryName())
                .distinct()
                .sorted()
                .forEach(n -> System.out.println(index.incrementAndGet() + ". " + n));


        InsideMenu.run();


    }

}
