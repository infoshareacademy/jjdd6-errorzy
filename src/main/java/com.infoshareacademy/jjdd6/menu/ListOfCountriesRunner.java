package com.infoshareacademy.jjdd6.menu;

import com.infoshareacademy.jjdd6.listOfPlaces.CountryPrinter;

import javax.xml.bind.JAXBException;


public class ListOfCountriesRunner {
    public static void run() throws JAXBException {

        CountryPrinter listOfCountries = new CountryPrinter();
        listOfCountries.printCountryList();
        InsideMenu.run();
    }

}
