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

    public PlaceStatistics update(PlaceStatistics p) {
        return entityManager.merge(p);
    }

    public void save(PlaceStatistics place) {
        entityManager.persist(place);
    }

    public void delete(String place) {
        final PlaceStatistics p = entityManager.find(PlaceStatistics.class, place);
        if (p != null) {
            entityManager.remove(p);
        }
    }

    public PlaceStatistics findByName(String place) {
        return entityManager.find(PlaceStatistics.class, place);
    }

    public List<PlaceStatistics> findAll() {
        final Query query = entityManager.createQuery("SELECT p FROM PlaceStatistics p");

        return query.getResultList();
    }

    public List<PlaceStatistics> findMostChecked() {
        final Query query = entityManager.createQuery("SELECT p FROM PlaceStatistics p WHERE numberOfVisits = SELECT max(numberOfVisits) FROM PlaceStatistics)");

        return query.getResultList();
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

