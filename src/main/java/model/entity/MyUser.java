package model.entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "MyUser.findAll", query = "SELECT u FROM MyUser u"),
        @NamedQuery(name = "MyUser.findById", query = "SELECT u FROM MyUser u WHERE u.id = :id"),
        @NamedQuery(name = "MyUser.findByName", query = "SELECT u FROM MyUser u WHERE u.name = :name"),
        @NamedQuery(name = "MyUser.findBySurname", query = "SELECT u FROM MyUser u WHERE u.surname = :surname"),
        @NamedQuery(name = "MyUser.findByBirthday", query = "SELECT u FROM MyUser u WHERE u.birthday = :birthday"),
        @NamedQuery(name = "MyUser.findByAccount", query = "SELECT u FROM MyUser u WHERE u.account = :account"),
})
public class MyUser {
    @GeneratedValue
    @Id
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String surname;
    @Column(name = "gender")
    private String gender;
    private Date birthday;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Habit> userHabits;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_challenge", // Tên bảng trung gian
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "challenge_id")
    )
    private List<Challenge> challenges;

    public MyUser() {}

    public long getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setUserHabits(List<Habit> userHabits) {
        this.userHabits = userHabits;
    }

    public List<Habit> getUserHabits() {
        return userHabits;
    }

    public void addUserHabit(Habit habit) {
        userHabits.add(habit);
        habit.setUser(this);
    }

    public void removeUserHabit(Habit habit) {
        userHabits.remove(habit);
        habit.setUser(null);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void addChallenge(Challenge challenge) {
        challenges.add(challenge);
        challenge.getUsers().add(this);
    }

    public void removeChallenge(Challenge challenge) {
        challenges.remove(challenge);
        challenge.getUsers().remove(this);
    }
    public String getGender() {return gender;}
    public  void setGender(String gender) {this.gender = gender;}
    public boolean hasHabit(Habit habit) {
        List<Habit> userHabits = getUserHabits(); // Làm thế nào để bạn lấy danh sách thói quen của người dùng, phụ thuộc vào thiết kế của bạn
        return userHabits.contains(habit);
    }
}
