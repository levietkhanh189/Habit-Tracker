package model.dao;

import model.entity.Connect;
import model.entity.ConnectInfo;
import model.entity.MyUser;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class ConnectDAO {

    private EntityManager entityManager;

    public ConnectDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Connect connect) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(connect);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public Connect findById(Long connectId) {
        return entityManager.find(Connect.class, connectId);
    }

    public List<Connect> findAll() {
        TypedQuery<Connect> query = entityManager.createNamedQuery("Connect.findAll", Connect.class);
        return query.getResultList();
    }

    public List<Connect> findByUser(MyUser user) {
        TypedQuery<Connect> query = entityManager.createNamedQuery("Connect.findByUser", Connect.class);
        query.setParameter("userId", user.getId());
        return query.getResultList();
    }

    public List<Connect> findByDate(Date connectDate) {
        TypedQuery<Connect> query = entityManager.createNamedQuery("Connect.findByDate", Connect.class);
        query.setParameter("connectDate", connectDate);
        return query.getResultList();
    }

    public void update(Connect connect) {
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(connect);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Connect connect) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(connect);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public ConnectInfo getConnectInfo(Connect connect) {
        return connect.getConnectInfo();
    }

    public MyUser getUser(Connect connect) {
        return connect.getUser();
    }

    public MyUser getFriend(Connect connect) {
        return connect.getConnectInfo().getFriend();
    }


    // Other methods related to Connect
}
