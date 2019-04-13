package com.infoshareacademy.jjdd6.menu;

import com.infoshareacademy.jjdd6.listOfPlaces.CityPrinter;

import javax.xml.bind.JAXBException;


public class ListOfCitiesRunner {
    public static void run() throws JAXBException {

        CityPrinter listOfCities = new CityPrinter();
        listOfCities.printCityList();
        InsideMenu.run();

    }
}
