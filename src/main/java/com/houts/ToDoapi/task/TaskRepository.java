package com.houts.ToDoapi.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {


    @Query("SELECT t FROM Task t WHERE t.user_profile_id = ?1")
    List<Task> findAllByUserProfileId(Long id);

    Task findTaskById(Long id);

}
