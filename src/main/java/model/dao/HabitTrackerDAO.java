package model.dao;

import model.entity.Habit;
import model.entity.HabitTracker;
import model.entity.MyUser;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.Date;
import java.util.List;

public class HabitTrackerDAO {

    private EntityManager entityManager;

    public HabitTrackerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(HabitTracker habitTracker) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(habitTracker);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public HabitTracker findById(Long habitTrackerId) {
        return entityManager.find(HabitTracker.class, habitTrackerId);
    }

    public List<HabitTracker> findByUser(MyUser user) {
        Query query = entityManager.createNamedQuery("HabitTracker.findByUser", HabitTracker.class);
        query.setParameter("user", user);
        return query.getResultList();
    }

    public List<HabitTracker> findByHabit(Habit habit) {
        Query query = entityManager.createNamedQuery("HabitTracker.findByHabit", HabitTracker.class);
        query.setParameter("habit", habit);
        return query.getResultList();
    }

    public List<HabitTracker> findByUserAndHabit(MyUser user, Habit habit) {
        Query query = entityManager.createNamedQuery("HabitTracker.findByUserAndHabit", HabitTracker.class);
        query.setParameter("user", user);
        query.setParameter("habit", habit);
        return query.getResultList();
    }

    public List<HabitTracker> findByStatus(String status) {
        Query query = entityManager.createNamedQuery("HabitTracker.findByStatus", HabitTracker.class);
        query.setParameter("status", status);
        return query.getResultList();
    }

    public List<HabitTracker> findByDate(Date date) {
        Query query = entityManager.createNamedQuery("HabitTracker.findByDate", HabitTracker.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    public List<HabitTracker> findByUserAndDate(MyUser user, Date date) {
        Query query = entityManager.createNamedQuery("HabitTracker.findByUserAndDate", HabitTracker.class);
        query.setParameter("user", user);
        query.setParameter("date", date);
        return query.getResultList();
    }

    public void update(HabitTracker habitTracker) {
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(habitTracker);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(HabitTracker habitTracker) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(habitTracker);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public MyUser getUser(HabitTracker habitTracker) {
        return habitTracker.getUser();
    }

    public Habit getHabit(HabitTracker habitTracker) {
        return habitTracker.getHabit();
    }

    // Other methods related to HabitTracker
}
