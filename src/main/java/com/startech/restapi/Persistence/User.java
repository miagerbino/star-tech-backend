package com.startech.restapi.Persistence;

        import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() { }
}
