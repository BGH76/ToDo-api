package com.houts.ToDoapi.task;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Task")
@Table(name = "Task")
public class Task {

    @Id
    @SequenceGenerator(name = "task_sequence", sequenceName = "task_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "user_profile_id")
    private Long user_profile_id;

    @Column(name = "task")
    private String task;

    @Column(name = "date_task_created", updatable = false)
    private LocalDate date_task_created;

    @Column(name = "task_complete")
    private Boolean complete;

    public Task() {
    }

    public Task(Long user_profile_id, String task, LocalDate date_task_created, Boolean complete) {
        this.user_profile_id = user_profile_id;
        this.task = task;
        this.date_task_created = date_task_created;
        this.complete = complete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_profile_id() {
        return user_profile_id;
    }

    public void setUser_profile_id(Long user_profile_id) {
        this.user_profile_id = user_profile_id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDate_task_created() {
        return date_task_created;
    }

    public void setDate_task_created(LocalDate date_task_created) {
        this.date_task_created = date_task_created;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", user_profile_id=" + user_profile_id +
                ", task='" + task + '\'' +
                ", date_task_created=" + date_task_created +
                ", complete=" + complete +
                '}';
    }
}
