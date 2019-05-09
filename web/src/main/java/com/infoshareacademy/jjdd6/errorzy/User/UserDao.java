package com.infoshareacademy.jjdd6.errorzy.User;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    public UserModel update(UserModel u) {
        return entityManager.merge(u);
    }

    public Long save(UserModel u) {
        entityManager.persist(u);
        return u.getUserId();
    }

    public void delete(Long id) {
        final UserModel u = entityManager.find(UserModel.class, id);
        if (u != null) {
            entityManager.remove(u);
        }
    }

    public UserModel findById(String id) {
        return entityManager.find(UserModel.class, id);
    }

    public List<UserModel> findAll() {
        final Query query = entityManager.createQuery("SELECT u FROM UserModel u");
        return query.getResultList();
    }
}
