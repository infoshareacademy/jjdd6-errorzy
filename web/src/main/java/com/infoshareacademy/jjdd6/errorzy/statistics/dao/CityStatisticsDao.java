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

    public CityStatistics update(CityStatistics cit) {
        return entityManager.merge(cit);
    }

    public void save(CityStatistics city) {
        entityManager.persist(city);
    }

    public void delete(String city) {
        final CityStatistics cit = entityManager.find(CityStatistics.class, city);
        if (cit != null) {
            entityManager.remove(cit);
        }
    }

    public CityStatistics findByName(String city) {
        return entityManager.find(CityStatistics.class, city);
    }

    public List<CityStatistics> findAll() {
        final Query query = entityManager.createQuery("SELECT cit FROM CityStatistics cit");

        return query.getResultList();
    }

    public List<CityStatistics> findMostChecked() {
        final Query query = entityManager.createQuery("SELECT cit FROM CityStatistics cit WHERE numberOfVisits = SELECT max(numberOfVisits) FROM CityStatistics)");

        return query.getResultList();
    }

    public void addToStatistics(String city) {
        final Query query = entityManager.createNativeQuery(
                "INSERT INTO CITY_STATISTICS (name, numberOfVisits) " +
                        "VALUES(:city, 1 ) ON DUPLICATE KEY UPDATE " +
                        "numberOfVisits = numberOfVisits +1");
        query.setParameter("city", city.toUpperCase());
        query.executeUpdate();
        return;
    }
}


