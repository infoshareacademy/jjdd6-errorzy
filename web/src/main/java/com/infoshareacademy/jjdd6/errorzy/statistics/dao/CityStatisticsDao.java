package com.infoshareacademy.jjdd6.errorzy.statistics.dao;

import com.infoshareacademy.jjdd6.errorzy.statistics.model.CityStatistics;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class CityStatisticsDao {

    @PersistenceContext
    private EntityManager entityManager;

    public CityStatistics findByName(String city) {
        return entityManager.find(CityStatistics.class, city);
    }

    public List<CityStatistics> findAll() {
        final Query query = entityManager.createQuery("SELECT cit FROM CityStatistics cit");

        return query.getResultList();
    }

    public CityStatistics findMostChecked() {

        final Query query = entityManager.createQuery("SELECT cit.city FROM CityStatistics cit WHERE max (cit.numberOfVisits) = :numberOfVisits ORDER BY cit.city DESC ");
        return (CityStatistics) query.getSingleResult();
    }

    public void addToStatistics(String city) {
        CityStatistics stats = findByName(city);
        if (stats == null) {
            stats = new CityStatistics();
            stats.setCity(city);
            stats.setNumberOfVisits(1l);
            entityManager.persist(stats);
        } else {
            stats.setNumberOfVisits(stats.getNumberOfVisits() + 1);
            entityManager.merge(stats);
        }
    }
}



