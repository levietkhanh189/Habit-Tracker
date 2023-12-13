package model.dao;

import model.entity.ConnectInfo;
import model.entity.Connect;
import model.entity.MyUser;

import jakarta.persistence.EntityManager;

public class ConnectInfoDAO {

    private EntityManager entityManager;

    public ConnectInfoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(ConnectInfo connectInfo) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(connectInfo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public ConnectInfo findById(Long connectInfoId) {
        return entityManager.find(ConnectInfo.class, connectInfoId);
    }

    public void update(ConnectInfo connectInfo) {
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(connectInfo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(ConnectInfo connectInfo) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(connectInfo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public Connect getConnect(ConnectInfo connectInfo) {
        return connectInfo.getConnect();
    }

    public MyUser getFriend(ConnectInfo connectInfo) {
        return connectInfo.getFriend();
    }

    // Other methods related to ConnectInfo
}
