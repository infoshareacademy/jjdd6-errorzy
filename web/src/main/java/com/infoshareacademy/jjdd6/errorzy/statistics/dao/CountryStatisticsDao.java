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

    public CountryStatistics update(CountryStatistics cou) {
        return entityManager.merge(cou);
    }

    public void save(CountryStatistics country) {
        entityManager.persist(country);
    }

    public void delete(String country) {
        final CountryStatistics cou = entityManager.find(CountryStatistics.class, country);
        if (cou != null) {
            entityManager.remove(cou);
        }
    }

    public CountryStatistics findByName(String country) {
        return entityManager.find(CountryStatistics.class, country);
    }

    public List<CountryStatistics> findAll() {
        final Query query = entityManager.createQuery("SELECT cou FROM CountryStatistics cou");

        return query.getResultList();
    }

    public List<CountryStatistics> findMostChecked() {
        final Query query = entityManager.createQuery("SELECT cou FROM CountryStatistics cou WHERE numberOfVisits = SELECT max(numberOfVisits) FROM CountryStatistics)");

        return query.getResultList();
    }

    public void addToStatistics(String country) {
        final Query query = entityManager.createNativeQuery(
                "INSERT INTO COUNTRY_STATISTICS (name, numberOfVisits) " +
                        "VALUES(:country, 1 ) ON DUPLICATE KEY UPDATE " +
                        "numberOfVisits = numberOfVisits +1");
        query.setParameter("country", country.toUpperCase());
        query.executeUpdate();
        return;
    }
}
