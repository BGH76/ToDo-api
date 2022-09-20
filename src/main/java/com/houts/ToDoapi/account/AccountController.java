package com.houts.ToDoapi.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/account")
public class AccountController {

    private final AccountService account_service;

    @Autowired
    public AccountController(AccountService account_service) {
        this.account_service = account_service;
    }


    // ===== Checks for username availability =====
    @GetMapping(path = "usernames/{name}")
    public boolean getCurrentUsernames(@PathVariable("name") String name) {
        return account_service.checkForUsernameAvailability(name);
    }

    // ===== Creates a new account String data contains firstName, lastName, email, username, password =====
    @PostMapping(path = "createAccount")
    public boolean createAccount(@RequestBody String data) {
        return account_service.createAccount(data);
    }

    @PostMapping(path = "login")
    public Map<String, String> accountLogin(@RequestBody String data) {
        return account_service.accountLogin(data);
    }
}
