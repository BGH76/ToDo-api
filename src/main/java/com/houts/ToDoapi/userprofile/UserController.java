package com.houts.ToDoapi.userprofile;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserProfile> getUsers() {
        return userService.getUsers();
    }

    // Endpoint to get user and tasks by id
    @GetMapping(path = "tasks/{userId}")
    public List<UserProfile> getUsersTask(@PathVariable Long userId) {
        List<UserProfile> userProfile = userService.getUserTasks(userId);
        return userProfile;
    }

    // Endpoint to change users specific task complete to ture by id
    @PostMapping(path = "complete/{taskId}")
    public void setTaskCompleteToTrue(@PathVariable Long taskId) {
        userService.setTaskCompleteToTrue(taskId);
    }

}
