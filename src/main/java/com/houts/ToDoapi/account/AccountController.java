package com.houts.ToDoapi.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/account")
public class AccountController {

    private final AccountService account_service;

    @Autowired
    public AccountController(AccountService account_service) {
        this.account_service = account_service;
    }



    @GetMapping(path = "{account}")
    public Account getAccount(@PathVariable("account") Long id) {
        return account_service.getAccount(id);
    }


    @GetMapping()
    public List<Account> getAccounts() {
        return account_service.getAccounts();
    }


    @PostMapping
    public void createAccount(@RequestParam String firstName, String lastName, String email, String password, String username) {
        account_service.createAccount(firstName, lastName, email, password, username);
    }
}
