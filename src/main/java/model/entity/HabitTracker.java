package model.entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "HabitTracker.findAll", query = "SELECT ht FROM HabitTracker ht"),
        @NamedQuery(name = "HabitTracker.findByUser", query = "SELECT ht FROM HabitTracker ht WHERE ht.user = :user"),
        @NamedQuery(name = "HabitTracker.findByHabit", query = "SELECT ht FROM HabitTracker ht WHERE ht.habit = :habit"),
        @NamedQuery(name = "HabitTracker.findByUserAndHabit", query = "SELECT ht FROM HabitTracker ht WHERE ht.user = :user AND ht.habit = :habit"),
        @NamedQuery(name = "HabitTracker.findByStatus", query = "SELECT ht FROM HabitTracker ht WHERE ht.status = :status"),
        @NamedQuery(name = "HabitTracker.findByDate", query = "SELECT ht FROM HabitTracker ht WHERE ht.date = :date"),
        @NamedQuery(
                name = "HabitTracker.findByUserAndDate",
                query = "SELECT ht FROM HabitTracker ht WHERE ht.user = :user AND CAST(ht.date AS DATE) = :date"
        )})
public class HabitTracker {
    @GeneratedValue
    @Id
    @Column(name = "habittracker_id")
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private MyUser user;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "habit_id")
    private Habit habit;

    private String status;
    private Date date;
    public HabitTracker() {
        // Default constructor
    }

    public HabitTracker(MyUser user, Habit habit, String status, Date date) {
        this.user = user;
        this.habit = habit;
        this.status = status;
        this.date = date;
    }

    // Getter and setter methods for all fields

    // Additional methods
    public Long getId() {
        return id;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
