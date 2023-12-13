package model.dao;

import model.entity.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.*;


public class ChallengeDAO {
    private final EntityManager entityManager;

    public ChallengeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Challenge findById(Long id) {
        return entityManager.find(Challenge.class, id);
    }

    public List<Challenge> findAll() {
        TypedQuery<Challenge> query = entityManager.createNamedQuery("Challenge.findAll", Challenge.class);
        return query.getResultList();
    }

    public void save(Challenge challenge) {
        entityManager.getTransaction().begin();
        entityManager.persist(challenge);
        entityManager.getTransaction().commit();
    }

    public void update(Challenge challenge) {
        entityManager.getTransaction().begin();
        entityManager.merge(challenge);
        entityManager.getTransaction().commit();
    }

    public void delete(Challenge challenge) {
        entityManager.getTransaction().begin();
        entityManager.remove(challenge);
        entityManager.getTransaction().commit();
    }

    // Custom query methods
    public List<Challenge> findChallengesByUser(Long userId) {
        TypedQuery<Challenge> query = entityManager.createNamedQuery("Challenge.findByUser", Challenge.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<Challenge> findChallengesByHabit(Long habitId) {
        TypedQuery<Challenge> query = entityManager.createNamedQuery("Challenge.findByHabit", Challenge.class);
        query.setParameter("habitId", habitId);
        return query.getResultList();
    }

    public List<Challenge> findActiveChallenges() {
        TypedQuery<Challenge> query = entityManager.createNamedQuery("Challenge.findActiveChallenges", Challenge.class);
        query.setParameter("currentDate", new Date());
        return query.getResultList();
    }

    public long countAllChallenges() {
        TypedQuery<Long> query = entityManager.createNamedQuery("Challenge.countAll", Long.class);
        return query.getSingleResult();
    }

    // Custom query methods for additional named queries
    public List<Habit> getHabitsForChallenge(Long challengeId) {
        TypedQuery<Habit> query = entityManager.createNamedQuery("Challenge.getHabits", Habit.class);
        query.setParameter("challengeId", challengeId);
        return query.getResultList();
    }

    public List<Habit> getHabitsForUser(Long userId) {
        TypedQuery<Habit> query = entityManager.createNamedQuery("Challenge.getHabitsForUser", Habit.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<MyUser> getUsersForChallenge(Long challengeId) {
        TypedQuery<MyUser> query = entityManager.createNamedQuery("Challenge.getUsers", MyUser.class);
        query.setParameter("challengeId", challengeId);
        return query.getResultList();
    }
}
