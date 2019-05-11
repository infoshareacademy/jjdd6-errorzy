package com.infoshareacademy.jjdd6.errorzy.dao;

import com.infoshareacademy.jjdd6.errorzy.dao.genericdao.GenericDao;
import com.infoshareacademy.jjdd6.errorzy.model.CountryModel;

import javax.ejb.Stateless;

@Stateless
public class CountryDao extends GenericDao<CountryModel, Long> {

    public CountryDao() {
        super(CountryModel.class);
    }
}
