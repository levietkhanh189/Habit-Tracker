package model.dao;

import model.entity.Activity;
import model.entity.MyUser;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class ActivityDAO {

    private EntityManager entityManager;

    public ActivityDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Activity activity) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(activity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public Activity findById(Long activityId) {
        return entityManager.find(Activity.class, activityId);
    }

    public List<Activity> findAll() {
        TypedQuery<Activity> query = entityManager.createNamedQuery("Activity.findAll", Activity.class);
        return query.getResultList();
    }

    public List<Activity> findByUserId(Long userId) {
        TypedQuery<Activity> query = entityManager.createNamedQuery("Activity.findByUserId", Activity.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<Activity> findByType(String type) {
        TypedQuery<Activity> query = entityManager.createNamedQuery("Activity.findByType", Activity.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    public List<Activity> findByDate(Date activityDate) {
        TypedQuery<Activity> query = entityManager.createNamedQuery("Activity.findByDate", Activity.class);
        query.setParameter("activityDate", activityDate);
        return query.getResultList();
    }

    public long countAll() {
        TypedQuery<Long> query = entityManager.createNamedQuery("Activity.countAll", Long.class);
        return query.getSingleResult();
    }

    // Other methods related to Activity

    // Example method: Get user for a specific activity
    public MyUser getUserForActivity(Activity activity) {
        return activity.getUser();
    }
}
