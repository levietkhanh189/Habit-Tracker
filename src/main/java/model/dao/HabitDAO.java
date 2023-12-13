package model.dao;

import model.entity.Habit;
import model.entity.MyUser;
import model.entity.Reminder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class HabitDAO {

    private EntityManager entityManager;

    public HabitDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Habit habit) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(habit);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public Habit findById(Long habitId) {
        return entityManager.find(Habit.class, habitId);
    }

    public List<Habit> findByUser(MyUser user) {
        Query query = entityManager.createNamedQuery("Habit.findByUser", Habit.class);
        query.setParameter("user", user);
        return query.getResultList();
    }

    public List<Habit> findByType(String type) {
        Query query = entityManager.createNamedQuery("Habit.findByType", Habit.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    public List<Habit> findByUserAndType(MyUser user, String type) {
        Query query = entityManager.createNamedQuery("Habit.findByUserAndType", Habit.class);
        query.setParameter("user", user);
        query.setParameter("type", type);
        return query.getResultList();
    }

    public List<Habit> findByLocation(String location) {
        Query query = entityManager.createNamedQuery("Habit.findByLocation", Habit.class);
        query.setParameter("location", location);
        return query.getResultList();
    }

    public List<Habit> findByUserAndLocation(MyUser user, String location) {
        Query query = entityManager.createNamedQuery("Habit.findByUserAndLocation", Habit.class);
        query.setParameter("user", user);
        query.setParameter("location", location);
        return query.getResultList();
    }

    public void update(Habit habit) {
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(habit);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Habit habit) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(habit);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public MyUser getUser(Habit habit) {
        return habit.getUser();
    }

    public List<Reminder> getReminders(Habit habit) {
        return habit.getReminders();
    }

    // Other methods related to Habit
}
