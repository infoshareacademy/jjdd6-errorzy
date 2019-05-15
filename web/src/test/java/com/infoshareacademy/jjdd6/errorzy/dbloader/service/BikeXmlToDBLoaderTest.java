package com.infoshareacademy.jjdd6.errorzy.dbloader.service;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.BikeDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.PlaceModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.dbloaders.BikeXmlToDBLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BikeXmlToDBLoaderTest {

    @Mock
    private BikeDao bikeDao;
    @InjectMocks
    private BikeXmlToDBLoader sut;

    @Test
    public void shouldCheckIfBikeDaoExecuted() {
        //given
        //when
        sut.loadBikeModelToDataBase(new Place(54.123123, 18.42414124, "Dworzec", 1, null),
                new PlaceModel(54.123123, 18.42414124, "Gdynia", 1, null));

        //then
        verify(bikeDao, times(0)).save(any());
    }

}               