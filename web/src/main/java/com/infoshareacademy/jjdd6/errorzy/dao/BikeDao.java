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

    public BikeModel findByNumber(int number) {
        Query query = entityManager.createQuery("SELECT c FROM BikeModel c WHERE c.number = :number");
        query.setParameter("number", number);

        List<BikeModel> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }

}
