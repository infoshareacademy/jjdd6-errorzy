package com.infoshareacademy.jjdd6.errorzy.dao;

import com.infoshareacademy.jjdd6.errorzy.dao.genericdao.GenericDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;

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
}
