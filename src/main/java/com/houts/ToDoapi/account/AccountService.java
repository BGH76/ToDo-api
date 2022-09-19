package com.houts.ToDoapi.account;

import com.houts.ToDoapi.exception.NotFoundException;
import com.houts.ToDoapi.userprofile.UserProfile;
import com.houts.ToDoapi.userprofile.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
         return accountRepository.findAll();
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("Account with id " + id + " not found");
                    return notFoundException;
                });
    }

    public void createAccount(String firstName, String lastName, String email, String password, String username) {
        accountRepository.save(new Account(username, password, new UserProfile(firstName, lastName, email)));


    }
}
