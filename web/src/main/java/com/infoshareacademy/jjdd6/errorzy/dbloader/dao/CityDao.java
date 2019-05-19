package com.infoshareacademy.jjdd6.errorzy.dbloader.dao;

import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.genericdao.GenericDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CityModel;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CityDao extends GenericDao<CityModel, Long> {

    public CityDao() {
        super(CityModel.class);
    }

    public List<CityModel> findByCountry(String countryName) {
        Query query = entityManager.createQuery("SELECT c FROM CityModel c WHERE c.country.countryName = :name");
        query.setParameter("name", countryName);

        List<CityModel> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result;
        }
    }

    public CityModel findByName(String name) {
        Query query = entityManager.createQuery("SELECT c FROM CityModel c WHERE c.name = :cityName");
        query.setParameter("cityName", name);

        List<CityModel> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }
}
