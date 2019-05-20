package com.infoshareacademy.jjdd6.errorzy.dbloader.dao.genericdao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class GenericDao<U, T> {
    private Class<U> daoClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public GenericDao(Class<U> daoClass) {
        this.daoClass = daoClass;
    }

    public void save(U u) {
        entityManager.persist(u);
    }

    public U update(U u) {
        return entityManager.merge(u);
    }

    public void delete(T id) {
        final U u = entityManager.find(daoClass, id);
        if (u != null) {
            entityManager.remove(u);
        }
    }

    public U findById(T id) {
        return entityManager.find(daoClass, id);
    }

    public List<U> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM " + daoClass.getName() + " s");
        return query.getResultList();
    }

}