package model.entity;
import jakarta.persistence.*;

import java.sql.Time;

@Entity
@NamedQueries({
        @NamedQuery(name = "Reminder.findAll", query = "SELECT r FROM Reminder r"),
        @NamedQuery(name = "Reminder.findById", query = "SELECT r FROM Reminder r WHERE r.id = :id"),
        @NamedQuery(name = "Reminder.findByStatus", query = "SELECT r FROM Reminder r WHERE r.status = :status"),
        @NamedQuery(name = "Reminder.findByReminderTime", query = "SELECT r FROM Reminder r WHERE r.reminderTime = :reminderTime"),
})
public class Reminder {
    @GeneratedValue
    @Id
    @Column(name = "reminder_id")
    private Long id;
    private String status;
    private Time reminderTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "habit_id")
    private Habit habit;

    public Reminder() {
    }
    public Reminder(Reminder originalReminder,Habit habit) {
        this.status = originalReminder.getStatus();
        this.reminderTime = originalReminder.getReminderTime();
        this.habit = habit;
    }

    // Getter và Setter cho id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter và Setter cho status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter và Setter cho reminderTime
    public Time getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(Time reminderTime) {
        this.reminderTime = reminderTime;
    }

    // Getter và Setter cho habit
    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }
}
