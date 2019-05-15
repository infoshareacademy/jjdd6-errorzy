package com.infoshareacademy.jjdd6.errorzy.dbloader.service;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.CityDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.dbloaders.CityXmlToDBLoader;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.dbloaders.PlaceXmlToDBLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CityXmlToDBLoaderTest {

    @Mock
    CityDao cityDao;
    @Mock
    PlaceXmlToDBLoader placeXmlToDBLoader;
    @InjectMocks
    private CityXmlToDBLoader sut;

    @Test
    public void shouldReturnCorrectCityList() {
        //given
        doNothing().when(placeXmlToDBLoader).loadPlaceModelToDataBase(isA(City.class), isA(CityModel.class));

        //when
        sut.loadCityModelToDataBase(mockedCountryList().get(0), mockedCountryModelList().get(0));

        //then
        verify(cityDao, times(mockedCityList().size())).save(any());
    }

    private List<Country> mockedCountryList() {
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country(54.2323, 18.23232, "Poland", mockedCityList()));
        countryList.add(new Country(50.2323, 10.23232, "Germany", null));
        countryList.add(new Country(-54.2323, -100.23232, "Australia", null));
        countryList.add(new Country(134.2323, 40.23232, "USA", null));
        return countryList;
    }

    private List<City> mockedCityList() {
        List<City> cityList = new ArrayList<>();
        cityList.add(new City(54.2323, 18.3231, "Gdynia", null));
        cityList.add(new City(52.2323, 21.3231, "Warszawa", null));
        cityList.add(new City(49.2323, 24.3231, "Radom", null));
        return cityList;
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