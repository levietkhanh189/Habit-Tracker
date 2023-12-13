package model.dao;

import model.entity.MoodTracker;
import model.entity.MyUser;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.Date;
import java.util.List;

public class MoodTrackerDAO {

    private EntityManager entityManager;

    public MoodTrackerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(MoodTracker moodTracker) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(moodTracker);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public MoodTracker findById(Long moodTrackerId) {
        return entityManager.find(MoodTracker.class, moodTrackerId);
    }

    public List<MoodTracker> findByUser(MyUser user) {
        Query query = entityManager.createNamedQuery("MoodTracker.findByUser", MoodTracker.class);
        query.setParameter("user", user);
        return query.getResultList();
    }

    public List<MoodTracker> findByStatus(int status) {
        Query query = entityManager.createNamedQuery("MoodTracker.findByStatus", MoodTracker.class);
        query.setParameter("status", status);
        return query.getResultList();
    }

    public List<MoodTracker> findByDate(Date date) {
        Query query = entityManager.createNamedQuery("MoodTracker.findByDate", MoodTracker.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    public List<MoodTracker> findByUserAndDate(MyUser user, Date date) {
        Query query = entityManager.createNamedQuery("MoodTracker.findByUserAndDate", MoodTracker.class);
        query.setParameter("user", user);
        query.setParameter("date", date);
        return query.getResultList();
    }

    public void update(MoodTracker moodTracker) {
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(moodTracker);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(MoodTracker moodTracker) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(moodTracker);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    // Other methods related to MoodTracker
}
