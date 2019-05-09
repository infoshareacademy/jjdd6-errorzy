package com.infoshareacademy.jjdd6.errorzy.service;

import com.infoshareacademy.jjdd6.errorzy.dao.BikeDao;
import com.infoshareacademy.jjdd6.errorzy.model.BikeModel;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.BikeSearch;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Singleton
public class BikeXmlToDBLoader {
    private static final Logger LOGGER = Logger.getLogger(BikeXmlToDBLoader.class.getName());

    @Inject
    private BikeDao bikeDao;
    @Inject
    private BikeSearch bikeSearch;

    private void loadBikeXmlToDataBase(List<BikeModel> bikeModelList) {
        LOGGER.info("Loading to DB: " + bikeModelList);
        bikeModelList.forEach(bike -> bikeDao.save(bike));
    }

    public List<BikeModel> prepareBikeModelList(String placeName) {
        LOGGER.info("Bikes for place are being loaded" + placeName);
        List<BikeModel> bikeModelList = bikeSearch.getMapOfBikesForPlace(placeName).values().stream()
                .filter(Objects::nonNull)
                .map(bike -> new BikeModel(bike.getNumber(), bike.getBikeType()))
                .collect(Collectors.toList());
        loadBikeXmlToDataBase(bikeModelList);
        return bikeModelList;
    }
}
