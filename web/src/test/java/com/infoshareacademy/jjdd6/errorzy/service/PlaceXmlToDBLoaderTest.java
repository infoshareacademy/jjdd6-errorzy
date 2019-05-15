package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.dao.PlaceDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;
import com.infoshareacademy.jjdd6.errorzy.service.dbloaders.BikeXmlToDBLoader;
import com.infoshareacademy.jjdd6.errorzy.service.dbloaders.PlaceXmlToDBLoader;
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
class PlaceXmlToDBLoaderTest {

    @Mock
    PlaceDao placeDao;
    @Mock
    BikeXmlToDBLoader bikeXmlToDBLoader;
    @InjectMocks
    private PlaceXmlToDBLoader sut;

    @Test
    public void ShouldReturnCorrectCountryList() {
        //given
        doNothing().when(bikeXmlToDBLoader).loadBikeModelToDataBase(isA(Place.class), isA(PlaceModel.class));

        //when
        sut.loadPlaceModelToDataBase(new City(54.2323, 18.3231, "Gdynia", mockedPlaceList()),
                new CityModel(54.2323, 18.3231, "Gdynia", null));

        //then
        verify(placeDao, times(mockedPlaceList().size())).save(any());
    }

    private List<Place> mockedPlaceList() {
        List<Place> placeList = new ArrayList<>();
        placeList.add(new Place(54.123123, 18.42414124, "Dworzec", 1, null));
        return placeList;
    }
}               