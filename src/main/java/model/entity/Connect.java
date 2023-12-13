package model.entity;
import jakarta.persistence.*;

import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Connect.findAll", query = "SELECT c FROM Connect c"),
        @NamedQuery(name = "Connect.findById", query = "SELECT c FROM Connect c WHERE c.id = :connectId"),
        @NamedQuery(name = "Connect.findByUser", query = "SELECT c FROM Connect c WHERE c.user.id = :userId"),
        @NamedQuery(name = "Connect.findByDate", query = "SELECT c FROM Connect c WHERE c.date = :connectDate")
})
public class Connect {
    @GeneratedValue
    @Id
    @Column(name = "connect_id")
    private Long id;
    private Date date;
    @OneToOne(mappedBy = "connect", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private ConnectInfo connectInfo;
    @OneToOne(optional = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private MyUser user;

    // Constructors
    public Connect() {
        // Default constructor
    }

    public Connect(Date date, ConnectInfo connectInfo, MyUser user) {
        this.date = date;
        this.connectInfo = connectInfo;
        this.user = user;
    }

    // Getter and setter methods for all fields

    // Additional methods
    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ConnectInfo getConnectInfo() {
        return connectInfo;
    }

    public void setConnectInfo(ConnectInfo connectInfo) {
        this.connectInfo = connectInfo;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public MyUser getFriend() {
        return this.connectInfo.getFriend();
    }

    public void setFriend(MyUser friend) {
        this.connectInfo.setFriend(friend);
    }
}
