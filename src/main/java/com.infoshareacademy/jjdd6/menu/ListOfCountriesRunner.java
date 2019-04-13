package com.infoshareacademy.jjdd6.menu;

import com.infoshareacademy.jjdd6.listOfPlaces.ListOfCountries;

import javax.xml.bind.JAXBException;


public class ListOfCountriesRunner {
    public static void run() throws JAXBException {

        ListOfCountries listOfCountries = new ListOfCountries();
        listOfCountries.run();
        InsideMenu.run();
    }

}
