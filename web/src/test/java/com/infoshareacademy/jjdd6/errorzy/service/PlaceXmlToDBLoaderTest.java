package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.dao.PlaceDao;
import com.infoshareacademy.jjdd6.errorzy.model.BikeModel;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.PlaceSearch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlaceXmlToDBLoaderTest {

    @Mock
    private PlaceDao placeDao;
    @Mock
    private PlaceSearch placeSearch;
    @Mock
    private BikeXmlToDBLoader bikeXmlToDBLoader;

    @InjectMocks
    private PlaceXmlToDBLoader classUnderTest;

    @Test
    public void shouldReturnCorrectListOfPlaceModel() {
        // given
//        when(placeSearch.getPlaces()).thenReturn(mockedPlaceList());
//        String mockedPlaceName1 = "Metro Imielin";
//        when(bikeXmlToDBLoader.loadBikeModelToDataBase(Mockito.eq(mockedPlaceName1)))
//                .thenReturn(mockedBikeModelList());
//        String mockedPlaceName2 = "Metro Racławicka";
//        when(bikeXmlToDBLoader.loadBikeModelToDataBase(Mockito.eq(mockedPlaceName2)))
//                .thenReturn(mockedBikeModelList());
//        String mockedPlaceName3 = "Metro Kabaty";
//        when(bikeXmlToDBLoader.loadBikeModelToDataBase(Mockito.eq(mockedPlaceName3)))
//                .thenReturn(mockedBikeModelList());

//        // when
//        List<PlaceModel> result = classUnderTest.loadPlaceModelToDataBase();
//
//        // then
//        assertThat(result).extracting(PlaceModel::getName).containsExactly(mockedPlaceName1, mockedPlaceName2, mockedPlaceName3);
    }

//    private List<Place> mockedPlaceList() {
//        List<Place> placeList = new ArrayList<>();
//        placeList.add(new Place(54.1234, 18.6578, "Metro Imielin", 4, null));
//        placeList.add(new Place(34.1234, 11.6578, "Metro Racławicka", 1, null));
//        placeList.add(new Place(64.1234, 14.6578, "Metro Kabaty", 6, null));
//        return placeList;
//    }
//
//    private List<BikeModel> mockedBikeModelList() {
//        List<BikeModel> bikeModelList = new ArrayList<>();
//        bikeModelList.add(new BikeModel(15555, 15));
//        bikeModelList.add(new BikeModel(16666, 16));
//        bikeModelList.add(new BikeModel(17777, 17));
//        return bikeModelList;
//    }

}               