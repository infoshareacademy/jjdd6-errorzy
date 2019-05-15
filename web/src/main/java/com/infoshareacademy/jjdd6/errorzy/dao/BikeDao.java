package com.infoshareacademy.jjdd6.errorzy.dao;

import com.infoshareacademy.jjdd6.errorzy.dao.genericdao.GenericDao;
import com.infoshareacademy.jjdd6.errorzy.model.BikeModel;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

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
}
