package com.infoshareacademy.jjdd6.errorzy.statistics;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.FindCity;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.FindCountry;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.stream.Collectors;

public class Statistics {
    public static List<Country> statisticsForCountry(String countryNm) throws JAXBException {
        FindCountry findCountry = new FindCountry();
        List<Country> countries = findCountry.getCountries();
        List<City> cities = countries.stream().filter(x -> x.getCountryName().equals(countryNm)).flatMap(c -> c.getCityList().stream()).collect(Collectors.toList());
        List<Place> places = cities.stream().flatMap(c -> c.getPlaceList().stream()).collect(Collectors.toList());
        long totalLong = places.stream().count();
        System.out.println(totalLong);


        return countries;

    }

    public static List<City> statisticsForCities(String cityNm) throws JAXBException {
        FindCity findCity = new FindCity();
        List<City> cities = findCity.getCities();
        List<Place> places = cities.stream().filter(x -> x.getName().equals(cityNm)).flatMap(c -> c.getPlaceList().stream()).collect(Collectors.toList());
        long totalLong = places.stream().count();
        System.out.println(totalLong);

        return cities;

    }
}
