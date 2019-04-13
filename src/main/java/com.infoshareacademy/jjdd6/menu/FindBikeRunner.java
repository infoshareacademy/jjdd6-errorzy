package com.infoshareacademy.jjdd6.menu;

import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.FindCity;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.FindCountry;

import javax.xml.bind.JAXBException;

public class FindBikeRunner {

    public static void run() {
        FindCity findCity = new FindCity();
        FindCountry findCountry = new FindCountry();

        try {
            findCountry.getCountries().stream().map(c->c.getCountryName()).distinct().forEach(System.out::println);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
//        findCity.getCitiesForCountry()
        InsideMenu.run();
    }
}