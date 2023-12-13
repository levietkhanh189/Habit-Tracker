package model.entity;
import jakarta.persistence.*;

import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Habit.findAll", query = "SELECT h FROM Habit h"),
        @NamedQuery(name = "Habit.findByUser", query = "SELECT h FROM Habit h WHERE h.user = :user"),
        @NamedQuery(name = "Habit.findByType", query = "SELECT h FROM Habit h WHERE h.type = :type"),
        @NamedQuery(name = "Habit.findByUserAndType", query = "SELECT h FROM Habit h WHERE h.user = :user AND h.type = :type"),
        @NamedQuery(name = "Habit.findByLocation", query = "SELECT h FROM Habit h WHERE h.location = :location"),
        @NamedQuery(name = "Habit.findByUserAndLocation", query = "SELECT h FROM Habit h WHERE h.user = :user AND h.location = :location")
})
public class Habit {
    @GeneratedValue
    @Id
    @Column(name = "habit_id")
    private Long id;
    private String type;
    private String icon;
    private String habitName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private MyUser user;

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Reminder> reminders;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "challenge_id")
    private Challenge challengeHabits;
    private String habitType;

    private String location;
    public Habit() {
        // Default constructor
    }

    public Habit(String type, String icon, String habitName, MyUser user,Challenge challengeHabits, String habitType, String location) {
        this.type = type;
        this.icon = icon;
        this.habitName = habitName;
        this.user = user;
        this.habitType = habitType;
        this.location = location;
        this.challengeHabits = challengeHabits;
    }

    public Habit(Habit originalHabit) {
        this.type = originalHabit.getType();
        this.icon = originalHabit.getIcon();
        this.habitName = originalHabit.getHabitName();
        this.user = originalHabit.getUser();
        this.habitType = originalHabit.getHabitType();
        this.location = originalHabit.getLocation();

        // Clone the list of reminders if needed
        if (originalHabit.getReminders() != null) {
            this.reminders = new ArrayList<>(originalHabit.getReminders().size());
            for (Reminder originalReminder : originalHabit.getReminders()) {
                Reminder newReminder = new Reminder(originalReminder,this);
                newReminder.setHabit(this);
                this.reminders.add(newReminder);
            }
        }
    }
    public Long getId() {
        return id;
    }
    public String getIdToString() {
        return id.toString();
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public List<Reminder> getReminders() {
        return reminders;
    }

    public void setReminders(List<Reminder> reminders) {
        this.reminders = reminders;
    }

    public Challenge getChallengeHabits() {
        return challengeHabits;
    }

    public void setChallengeHabits(Challenge challengeHabits) {
        this.challengeHabits = challengeHabits;
    }

    public String getHabitType() {
        return habitType;
    }

    public void setHabitType(String habitType) {
        this.habitType = habitType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Other methods
    public void addReminder(Reminder reminder) {
        reminders.add(reminder);
        reminder.setHabit(this);
    }

    public void removeReminder(Reminder reminder) {
        reminders.remove(reminder);
        reminder.setHabit(null);
    }
}
