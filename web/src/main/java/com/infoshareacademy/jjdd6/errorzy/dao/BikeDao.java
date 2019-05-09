package com.infoshareacademy.jjdd6.errorzy.dao;

import com.infoshareacademy.jjdd6.errorzy.Bike;
import com.infoshareacademy.jjdd6.errorzy.dao.genericdao.GenericDao;

import javax.ejb.Stateless;

@Stateless
public class BikeDao extends GenericDao<Bike, Long> {
    public BikeDao() {
        super(Bike.class);
    }
}
