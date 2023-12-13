package model.entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "MoodTracker.findAll", query = "SELECT mt FROM MoodTracker mt"),
        @NamedQuery(name = "MoodTracker.findByUser", query = "SELECT mt FROM MoodTracker mt WHERE mt.user = :user"),
        @NamedQuery(name = "MoodTracker.findByStatus", query = "SELECT mt FROM MoodTracker mt WHERE mt.status = :status"),
        @NamedQuery(name = "MoodTracker.findByDate", query = "SELECT mt FROM MoodTracker mt WHERE mt.date = :date"),
        @NamedQuery(name = "MoodTracker.findByUserAndDate", query = "SELECT mt FROM MoodTracker mt WHERE mt.user = :user AND mt.date = :date"),
})
public class MoodTracker {
    @GeneratedValue
    @Id
    @Column(name = "moodtracker_id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private MyUser user;

    private int status;
    private Date date;
    // Constructors
    public MoodTracker() {
        // Default constructor
    }

    public MoodTracker(MyUser user, int status, Date date) {
        this.user = user;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
