package model.dao;

import model.entity.Reminder;
import model.entity.Habit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.sql.Time;
import java.util.List;

public class ReminderDAO {
    private EntityManager entityManager;

    public ReminderDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Reminder reminder) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(reminder);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public Reminder findById(Long reminderId) {
        return entityManager.find(Reminder.class, reminderId);
    }

    public List<Reminder> findByStatus(String status) {
        Query query = entityManager.createNamedQuery("Reminder.findByStatus", Reminder.class);
        query.setParameter("status", status);
        return query.getResultList();
    }

    public List<Reminder> findByReminderTime(Time reminderTime) {
        Query query = entityManager.createNamedQuery("Reminder.findByReminderTime", Reminder.class);
        query.setParameter("reminderTime", reminderTime);
        return query.getResultList();
    }

    public void update(Reminder reminder) {
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(reminder);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Reminder reminder) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(reminder);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }
}
