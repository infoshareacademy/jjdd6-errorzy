package com.infoshareacademy.jjdd6.errorzy.dao;

import com.infoshareacademy.jjdd6.errorzy.dao.genericdao.GenericDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PlaceDao extends GenericDao<PlaceModel, Long> {

    public PlaceDao() {
        super(PlaceModel.class);
    }

    public PlaceModel findByName(String name) {
        Query query = entityManager.createQuery("SELECT c FROM PlaceModel c WHERE c.name = :name");
        query.setParameter("name", name);

        List<PlaceModel> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }
}
