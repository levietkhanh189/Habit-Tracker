package model.dao;

import model.entity.MyUser;
import model.entity.Habit;
import model.entity.Account;
import model.entity.Challenge;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.*;

public class MyUserDAO {

    private EntityManager entityManager;

    public MyUserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(MyUser user) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public MyUser findById(Long userId) {
        return entityManager.find(MyUser.class, userId);
    }

    public List<MyUser> findByName(String name) {
        Query query = entityManager.createNamedQuery("MyUser.findByName", MyUser.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<MyUser> findBySurname(String surname) {
        Query query = entityManager.createNamedQuery("MyUser.findBySurname", MyUser.class);
        query.setParameter("surname", surname);
        return query.getResultList();
    }

    public List<MyUser> findByBirthday(Date birthday) {
        Query query = entityManager.createNamedQuery("MyUser.findByBirthday", MyUser.class);
        query.setParameter("birthday", birthday);
        return query.getResultList();
    }

    public List<MyUser> findByAccount(Account account) {
        Query query = entityManager.createNamedQuery("MyUser.findByAccount", MyUser.class);
        query.setParameter("account", account);
        return query.getResultList();
    }

    public void update(MyUser user) {
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(MyUser user) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    // Other methods related to MyUser
}
