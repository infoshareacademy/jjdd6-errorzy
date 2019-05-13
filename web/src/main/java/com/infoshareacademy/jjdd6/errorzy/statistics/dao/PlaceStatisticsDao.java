package com.infoshareacademy.jjdd6.errorzy.statistics.dao;

import com.infoshareacademy.jjdd6.errorzy.statistics.model.PlaceStatistics;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class PlaceStatisticsDao {
    @PersistenceContext

    private EntityManager entityManager;

    public PlaceStatistics findByName(String place) {
        return entityManager.find(PlaceStatistics.class, place);
    }

    public List<PlaceStatistics> findAll() {
        final Query query = entityManager.createQuery("SELECT p FROM PlaceStatistics p");

        return query.getResultList();
    }

    public PlaceStatistics findMostChecked() {
        final Query query = entityManager.createQuery("SELECT p.place FROM PlaceStatistics p WHERE max (p.numberOfVisits) = :numberOfVisits ORDER BY p.place DESC ");
        return (PlaceStatistics) query.getSingleResult();
    }

    public void addToStatistics(String place) {
        PlaceStatistics stats = findByName(place);
        if (stats == null) {
            stats = new PlaceStatistics();
            stats.setPlace(place);
            stats.setNumberOfVisits(1l);
            entityManager.persist(stats);
        } else {
            stats.setNumberOfVisits(stats.getNumberOfVisits() + 1);
            entityManager.merge(stats);
        }
    }
}

