package com.houts.ToDoapi.account;

import com.houts.ToDoapi.userprofile.UserProfile;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Account")
@Table(name = "Account")
public class Account {
    @Id
    @SequenceGenerator(name = "account_sequence", sequenceName = "account_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "username", updatable = false, unique = true)
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_profile_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "user_profile_fk"))
    private UserProfile user_profile;
    @Column(name = "password")
    private String password;
    @Column(name = "date_created", updatable = false)
    private LocalDate date_created = LocalDate.now();
    @Column(name = "active")
    private Boolean active = true;

    public Account() {
    }

    public Account(String username, String password, UserProfile user_profile) {
        this.username = username;
        this.password = password;
        this.user_profile = user_profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserProfile getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(UserProfile user_profile) {
        this.user_profile = user_profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user_profile=" + user_profile +
                ", password='" + password + '\'' +
                ", date_created=" + date_created +
                ", active=" + active +
                '}';
    }
}
