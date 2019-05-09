package com.infoshareacademy.jjdd6.errorzy.dao;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.dao.genericdao.GenericDao;

import javax.ejb.Stateless;

@Stateless
public class PlaceDao extends GenericDao<Place, Long> {

    public PlaceDao() {
        super(Place.class);
    }
}
