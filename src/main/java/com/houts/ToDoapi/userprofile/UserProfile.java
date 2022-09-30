package com.houts.ToDoapi.userprofile;

import com.houts.ToDoapi.task.Task;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "User_Profile")
@Table(name = "User_Profile")
public class UserProfile {

    @Id
    @SequenceGenerator(name = "user_profile_id_sequence", sequenceName = "user_profile_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_profile_id_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email", unique = true)
    private String email;

    @Transient
    private List<Task> taskList = new ArrayList<>();


    public UserProfile() {
    }

    public UserProfile(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }
    public List getTaskList() {
        return this.taskList;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
