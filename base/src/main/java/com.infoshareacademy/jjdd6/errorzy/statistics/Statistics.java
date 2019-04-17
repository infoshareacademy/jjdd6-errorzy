package com.infoshareacademy.jjdd6.errorzy.statistics;
import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CitySearch;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.stream.Collectors;

public class Statistics {
    public static List<Country> statisticsForCountry(String countryNm) throws JAXBException {
        CountrySearch findCountry = new CountrySearch();
        List<Country> countries = findCountry.getCountries();

        List<City> cities = countries
                .stream()
                .filter(x -> x.getCountryName().equals(countryNm))
                .flatMap(c -> c.getCityList()
                        .stream())
                .collect(Collectors.toList());

        List<Place> places = cities
                .stream()
                .flatMap(c -> c.getPlaceList()
                        .stream())
                .collect(Collectors.toList());

        System.out.println(places.size());
        return countries;
    }

    public static List<City> statisticsForCities(String cityNm) throws JAXBException {
        CitySearch findCity = new CitySearch();
        List<City> cities = findCity.getCities();
        List<Place> places = cities
                .stream()
                .filter(x -> x.getName().equals(cityNm))
                .flatMap(c -> c.getPlaceList()
                        .stream())
                .collect(Collectors.toList());

        System.out.println(places.size());
        return cities;
    }
}
