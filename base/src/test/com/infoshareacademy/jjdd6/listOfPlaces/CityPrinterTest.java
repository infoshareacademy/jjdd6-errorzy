package com.infoshareacademy.jjdd6.listOfPlaces;

import com.infoshareacademy.jjdd6.errorzy.City;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CityPrinterTest {

    @Mock
    private List<City> mockedList;

    void test() {
        mockedList = new ArrayList<>();
    }

    @Test

    void shouldPrintCityList() {
        // given

        // when

        // then

    }
}