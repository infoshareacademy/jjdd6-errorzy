package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;

import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class CountryXmlToDBLoader {

    @Inject
    private CountryDao countryDao;
    @Inject
    private CountrySearch countrySearch;
    @Inject
    private CityXmlToDBLoader cityXmlToDBLoader;
    @Inject
    private PlaceXmlToDBLoader placeXmlToDBLoader;
    @Inject
    private BikeXmlToDBLoader bikeXmlToDBLoader;

    public void loadCountryXmlToDataBase() {

    }

}
