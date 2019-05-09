package com.infoshareacademy.jjdd6.errorzy.dao;

import com.infoshareacademy.jjdd6.errorzy.dao.genericdao.GenericDao;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;

import javax.ejb.Stateless;

@Stateless
public class PlaceDao extends GenericDao<PlaceModel, Long> {

    public PlaceDao() {
        super(PlaceModel.class);
    }
}
