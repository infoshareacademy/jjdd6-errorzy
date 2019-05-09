package com.infoshareacademy.jjdd6.errorzy.dao;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.dao.genericdao.GenericDao;

import javax.ejb.Stateless;

@Stateless
public class CountryDao extends GenericDao<Country, Long> {

    public CountryDao() {
        super(Country.class);
    }
}
