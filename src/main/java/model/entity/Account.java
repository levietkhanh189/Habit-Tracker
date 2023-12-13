package model.entity;

import jakarta.persistence.*;
@Entity
@NamedQueries({
        @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
        @NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username = :username"),
        @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :accountId"),
        @NamedQuery(name = "Account.findByUserId", query = "SELECT a FROM Account a WHERE a.user.id = :userId"),
        @NamedQuery(name = "Account.findByUsernameAndPassword", query = "SELECT a FROM Account a WHERE a.username = :username AND a.password = :password"),
        @NamedQuery(name = "Account.findAllWithUser", query = "SELECT a FROM Account a JOIN FETCH a.user"),
        @NamedQuery(name = "Account.countAll", query = "SELECT COUNT(a) FROM Account a"),
        @NamedQuery(name = "Account.findAllWithUserAndNullableUser", query = "SELECT a FROM Account a LEFT JOIN FETCH a.user"),
        @NamedQuery(name = "Account.deleteByUsername", query = "DELETE FROM Account a WHERE a.username = :username")
})
public class Account {
    @GeneratedValue
    @Id
    @Column(name = "account_id")
    private Long id;
    private String username;
    private String password;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true)
    private MyUser user;

    public Account() {
        // Default constructor
    }

    public Account(String username, String password, MyUser user) {
        this.username = username;
        this.password = password;
        this.user = user;
    }

    // Getter and setter methods for all fields

    // Additional methods
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
