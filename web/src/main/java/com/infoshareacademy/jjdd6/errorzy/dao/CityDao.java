package com.infoshareacademy.jjdd6.errorzy.dao;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.dao.genericdao.GenericDao;

import javax.ejb.Stateless;

@Stateless
public class CityDao extends GenericDao<City, Long> {
    public CityDao() {
        super(City.class);
    }
}
