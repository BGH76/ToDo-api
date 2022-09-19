package com.houts.ToDoapi.userprofile;

import com.houts.ToDoapi.exception.NotFoundException;
import com.houts.ToDoapi.task.Task;
import com.houts.ToDoapi.task.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public UserService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    // Returns all users. TODO: if not used, remove
    public List<UserProfile> getUsers() {
        return userRepository.findAll();
    }

    // Returns user by email TODO: if not used, remove
    public UserProfile getUser(String email) {
        return userRepository.findUserProfileByEmail(email)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("User with " + email + " not found");
                    return notFoundException;
                });
    }

    // Returns a UserProfile by id with tasks attached as taskList to the controller
    // Data returned: UserProfile {id, first_name, last_name, email, taskList[{id, user_profile_id, task, date_task_created, complete}}]
    public List<UserProfile> getUserTasks(Long userId) {
        List<UserProfile> userProfile = userRepository.findUserProfileById(userId);
        List<Task> task = taskRepository.findAllByUserProfileId(userId);
        task.forEach((t) -> {
            userProfile.get(0).addTask(t);
        });
        System.out.println(userProfile);
        return userProfile;
    }

    // Method that gets task by id and changes completed to true. TODO: needs to only change task of specified user
    public void setTaskCompleteToTrue(Long id) {
        Task task = taskRepository.findTaskById(id);
        task.setComplete(true);
        taskRepository.save(task);


    }
}
