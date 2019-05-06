package com.infoshareacademy.jjdd6.menu;

import com.infoshareacademy.jjdd6.listOfPlaces.CityPrinter;

import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;

@Stateless
public class CitiesPrinterRunner {
    public static void run() throws JAXBException {

        CityPrinter listOfCities = new CityPrinter();
        listOfCities.printCityList();
        InsideMenu.run();

    }
}
