package model.entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a"),
        @NamedQuery(name = "Activity.findByUserId", query = "SELECT a FROM Activity a WHERE a.user.id = :userId"),
        @NamedQuery(name = "Activity.findByType", query = "SELECT a FROM Activity a WHERE a.type = :type"),
        @NamedQuery(name = "Activity.findByDate", query = "SELECT a FROM Activity a WHERE a.date = :activityDate"),
        @NamedQuery(name = "Activity.countAll", query = "SELECT COUNT(a) FROM Activity a")
})
public class Activity {
    @GeneratedValue
    @Id
    @Column(name = "activity_id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private MyUser user;
    private String type;
    private String content;
    private Date date;

    // Constructors
    public Activity() {
        // Default constructor
    }

    public Activity(MyUser user, String type, String content, Date date) {
        this.user = user;
        this.type = type;
        this.content = content;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
