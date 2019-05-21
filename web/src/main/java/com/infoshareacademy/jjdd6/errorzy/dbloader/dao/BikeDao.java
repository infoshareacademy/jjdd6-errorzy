package com.infoshareacademy.jjdd6.errorzy.dbloader.dao;

import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.genericdao.GenericDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.BikeModel;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class BikeDao extends GenericDao<BikeModel, Long> {

    public BikeDao() {
        super(BikeModel.class);
    }

    public List<BikeModel> findByPlace(String placeName) {
        Query query = entityManager.createQuery("SELECT b FROM BikeModel b WHERE b.place.name = :place");
        query.setParameter("place", placeName);

        List<BikeModel> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result;
        }
    }

    public Optional<BikeModel> findByNumber(int number) {
        Query query = entityManager.createQuery("SELECT b FROM BikeModel b WHERE b.number = :bikeNumber");
        query.setParameter("bikeNumber", number);

        List<BikeModel> result = query.getResultList();
        if (result.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(result.get(0));
        }
    }
}
