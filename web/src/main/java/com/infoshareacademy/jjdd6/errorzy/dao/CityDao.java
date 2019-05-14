package com.infoshareacademy.jjdd6.errorzy.dao;

import com.infoshareacademy.jjdd6.errorzy.dao.genericdao.GenericDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CityDao extends GenericDao<CityModel, Long> {
    public CityDao() {
        super(CityModel.class);
    }


    public CityModel findByName(String name) {
        Query query = entityManager.createQuery("SELECT c FROM CityModel c WHERE c.name = :name");
        query.setParameter("name", name);

        List<CityModel> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }
}
