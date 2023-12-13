package model.entity;
import jakarta.persistence.*;
import java.util.*;
@NamedQueries({
        @NamedQuery(name = "Challenge.findAll", query = "SELECT c FROM Challenge c"),
        @NamedQuery(name = "Challenge.findById", query = "SELECT c FROM Challenge c WHERE c.id = :challengeId"),
        @NamedQuery(name = "Challenge.findByName", query = "SELECT c FROM Challenge c WHERE c.name = :challengeName"),
        @NamedQuery(name = "Challenge.findByUser", query = "SELECT c FROM Challenge c JOIN c.users u WHERE u.id = :userId"),
        @NamedQuery(name = "Challenge.findByHabit", query = "SELECT c FROM Challenge c JOIN c.challengeHabits h WHERE h.id IN :habitIds"),
        @NamedQuery(name = "Challenge.findActiveChallenges", query = "SELECT c FROM Challenge c WHERE c.startDate <= :currentDate AND c.endDate >= :currentDate"),
        @NamedQuery(name = "Challenge.countAll", query = "SELECT COUNT(c) FROM Challenge c"),
        @NamedQuery(name = "Challenge.getHabits", query = "SELECT h FROM Challenge c JOIN c.challengeHabits h WHERE c.id = :challengeId"),
        @NamedQuery(name = "Challenge.getUsers", query = "SELECT u FROM Challenge c JOIN c.users u WHERE c.id = :challengeId"),
        @NamedQuery(name = "Challenge.getHabitsForUser", query = "SELECT h FROM Challenge c JOIN c.challengeHabits h JOIN c.users u WHERE u.id = :userId")
})
@Entity
public class Challenge {
    @GeneratedValue
    @Id
    @Column(name = "challenge_id")
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    @ManyToMany(mappedBy = "challenges")
    private List<MyUser> users;
    @OneToMany(mappedBy = "challengeHabits")
    private List<Habit> challengeHabits;

    // Constructors
    public Challenge() {
        // Default constructor
    }

    public Challenge(String name, String description, Date startDate, Date endDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getter and setter methods for all fields

    // Additional methods
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getEndDate() {
        return endDate.toString();
    }

    public List<MyUser> getUsers() {
        return users;
    }

    public void addUser(MyUser user) {
        users.add(user);
        user.getChallenges().add(this);
    }

    public void removeUser(MyUser user) {
        users.remove(user);
        user.getChallenges().remove(this);
    }

    public List<Habit> getChallengeHabits() {
        return challengeHabits;
    }

    public void addChallengeHabit(Habit habit) {
        challengeHabits.add(habit);
    }

    public void removeChallengeHabit(Habit habit) {
        challengeHabits.remove(habit);
   }

}
