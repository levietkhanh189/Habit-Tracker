package model.entity;

import jakarta.persistence.*;

@Entity
public class ConnectInfo {
    @Id
    @GeneratedValue
    @Column(name = "connect_info_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "connect_id")
    private Connect connect;

    @OneToOne(optional = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private MyUser friend;

    // Constructors
    public ConnectInfo() {
        // Default constructor
    }

    public ConnectInfo(Connect connect, MyUser friend) {
        this.connect = connect;
        this.friend = friend;
    }

    // Getter and setter methods for all fields

    // Additional methods
    public Long getId() {
        return id;
    }

    public Connect getConnect() {
        return connect;
    }

    public void setConnect(Connect connect) {
        this.connect = connect;
    }

    public MyUser getFriend() {
        return friend;
    }

    public void setFriend(MyUser friend) {
        this.friend = friend;
    }
}
