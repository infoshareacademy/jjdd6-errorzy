package com.infoshareacademy.jjdd6.errorzy.dbloader.dao;

import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.genericdao.GenericDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.PlaceModel;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PlaceDao extends GenericDao<PlaceModel, Long> {

    public PlaceDao() {
        super(PlaceModel.class);
    }

    public List<PlaceModel> findByCity(String cityName) {
        Query query = entityManager.createQuery("SELECT c FROM PlaceModel c WHERE c.city.name = :name");
        query.setParameter("name", cityName);

        List<PlaceModel> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result;
        }
    }

    public PlaceModel findByName(String name) {
        Query query = entityManager.createQuery("SELECT p FROM PlaceModel p WHERE p.name = :name");
        query.setParameter("name", name);

        List<PlaceModel> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }
}
