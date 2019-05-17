package com.infoshareacademy.jjdd6.errorzy.statistics.dao;

import com.infoshareacademy.jjdd6.errorzy.statistics.model.CountryStatistics;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class CountryStatisticsDao {

    @PersistenceContext
    private EntityManager entityManager;

    public CountryStatistics findByName(String country) {
        return entityManager.find(CountryStatistics.class, country);
    }

    public List<CountryStatistics> findAll() {
        final Query query = entityManager.createQuery("SELECT cou FROM CountryStatistics cou");
        return query.getResultList();
    }

    public CountryStatistics findMostChecked() {
        final Query query = entityManager.createQuery("SELECT cou.country FROM CountryStatistics cou WHERE max (cou.numberOfVisits) = :numberOfVisits ORDER BY cou.country DESC ");
        return (CountryStatistics) query.getSingleResult();
    }

    public void addToStatistics(String country) {
        CountryStatistics stats = findByName(country);
        if (stats == null) {
            stats = new CountryStatistics();
            stats.setCountry(country);
            stats.setNumberOfVisits(1l);
            entityManager.persist(stats);
        } else {
            stats.setNumberOfVisits(stats.getNumberOfVisits() + 1);
            entityManager.merge(stats);
        }
    }
}
