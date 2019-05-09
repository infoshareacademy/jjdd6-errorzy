package com.infoshareacademy.jjdd6.errorzy.dao;

import com.infoshareacademy.jjdd6.errorzy.Bike;
import com.infoshareacademy.jjdd6.errorzy.dao.genericdao.GenericDao;
import com.infoshareacademy.jjdd6.errorzy.model.BikeModel;

import javax.ejb.Stateless;

@Stateless
public class BikeDao extends GenericDao<BikeModel, Long> {
    public BikeDao() {
        super(BikeModel.class);
    }
}
