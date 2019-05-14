package com.infoshareacademy.jjdd6.errorzy.dao;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.dao.genericdao.GenericDao;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CountryDao extends GenericDao<CountryModel, Long> {

    public CountryDao() {
        super(CountryModel.class);
    }

    public CountryModel findByName(String name) {
        Query query = entityManager.createQuery("SELECT c FROM CountryModel c WHERE c.countryName = :name");
        query.setParameter("name", name);

        List<CountryModel> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }
}
