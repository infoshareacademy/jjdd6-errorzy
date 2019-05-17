package com.infoshareacademy.jjdd6.errorzy.dbloader.service;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.CountryDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.dbloaders.CityXmlToDBLoader;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.dbloaders.CountryXmlToDBLoader;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CountryXmlToDBLoaderTest {

    @Mock
    CountryDao countryDao;
    @Mock
    CountrySearch countrySearch;
    @Mock
    CityXmlToDBLoader cityXmlToDBLoader;

    @InjectMocks
    private CountryXmlToDBLoader sut;

    @Test
    public void shouldCheckIfCountryDaoExecuted() {
        //given
        when(countrySearch.getMapOfCountries()).thenReturn(mockedCountryMap());
        doNothing().when(cityXmlToDBLoader).loadCityModelToDataBase(isA(Country.class), isA(CountryModel.class));

        //when
        sut.loadCountryModelAtStart();

        //then
        verify(countryDao, times(mockedCountryMap().values().size())).save(any(CountryModel.class));
    }

    private List<Country> mockedCountryList() {
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country(54.2323, 18.23232, "Poland", null));
        countryList.add(new Country(50.2323, 10.23232, "Germany", null));
        countryList.add(new Country(-54.2323, -100.23232, "Australia", null));
        countryList.add(new Country(134.2323, 40.23232, "USA", null));
        return countryList;
    }

    private Map<String, Country> mockedCountryMap() {
        Map<String, Country> countryMap = new HashMap<>();
        countryMap.put("Poland", new Country(54.2323, 18.23232, "Poland", null));
        countryMap.put("Germany", new Country(50.2323, 10.23232, "Germany", null));
        countryMap.put("Australia", new Country(-54.2323, -100.23232, "Australia", null));
        countryMap.put("USA", new Country(134.2323, 40.23232, "USA", null));
        return countryMap;
    }

    private List<CountryModel> mockedCountryModelList() {
        List<CountryModel> countryModelList = new ArrayList<>();
        countryModelList.add(new CountryModel(54.2323, 18.23232, "Poland"));
        countryModelList.add(new CountryModel(50.2323, 10.23232, "Germany"));
        countryModelList.add(new CountryModel(-54.2323, -100.23232, "Australia"));
        countryModelList.add(new CountryModel(134.2323, 40.23232, "USA"));
        return countryModelList;
    }
}               