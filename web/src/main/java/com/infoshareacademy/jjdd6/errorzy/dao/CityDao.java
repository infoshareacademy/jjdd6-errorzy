package com.infoshareacademy.jjdd6.errorzy.dao;

import com.infoshareacademy.jjdd6.errorzy.dao.genericdao.GenericDao;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;

import javax.ejb.Stateless;

@Stateless
public class CityDao extends GenericDao<CityModel, Long> {
    public CityDao() {
        super(CityModel.class);
    }
}
