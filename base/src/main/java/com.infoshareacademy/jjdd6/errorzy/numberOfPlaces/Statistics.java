package com.infoshareacademy.jjdd6.errorzy.numberOfPlaces;
import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CitySearch;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;

import java.util.List;
import java.util.stream.Collectors;

public class Statistics {
    public static int getStatisticsForCountry(String countryNm)  {
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

        return places.size();
    }

    public static int getStatisticsForCities(String cityNm)  {
        CitySearch findCity = new CitySearch();
        List<City> cities = findCity.getCities();
        List<Place> places = cities
                .stream()
                .filter(x -> x.getName().equals(cityNm))
                .flatMap(c -> c.getPlaceList()
                        .stream())
                .collect(Collectors.toList());


        return places.size();
    }
}
