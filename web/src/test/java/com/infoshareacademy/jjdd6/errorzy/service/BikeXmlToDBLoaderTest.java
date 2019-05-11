package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.Bike;
import com.infoshareacademy.jjdd6.errorzy.dao.BikeDao;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.BikeSearch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class BikeXmlToDBLoaderTest {

    @Mock
    private BikeDao bikeDao;
    @Mock
    private BikeSearch bikeSearch;

    @InjectMocks
    private BikeXmlToDBLoader classUnderTest;


    @Test
    void shouldPrepareBikeModelList() {
//        // given
//        String placeName = "Metro Imielin";
//        when(bikeSearch.getMapOfBikesForPlace(Mockito.eq(placeName))).thenReturn(mockedBikeList());
//
//        // when
//        List<BikeModel> result = classUnderTest.loadBikeModelToDB(placeName);
//
//        // then
//        assertThat(result).extracting(BikeModel::getNumber).containsExactly(15223, 19223);
    }

    private Map<String, Bike> mockedBikeList() {

        Map<String, Bike> map = new HashMap<>();
        map.put("Metro Racławicka", new Bike(15223, 15));
        map.put("Metro Politechnika", new Bike(19223, 15));

        return map;
    }
}