package com.houts.ToDoapi.account;

import com.houts.ToDoapi.exception.NotFoundException;
import com.houts.ToDoapi.userprofile.UserProfile;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    // ===== Returns account by id =====
    public Account getAccount(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("Account with id " + id + " not found");
                    return notFoundException;
                });
    }

    // ===== Creates a new account =====
    // If new account is successful, method returns true.
    public boolean createAccount(String data) {
        JSONObject jsonObject = new JSONObject(data);
        try {
            accountRepository.save(new Account(
                    (String) jsonObject.get("username"),
                    (String) jsonObject.get("password"),
                    new UserProfile(
                            (String) jsonObject.get("firstName"),
                            (String) jsonObject.get("lastName"),
                            (String) jsonObject.get("email"))));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return checkForUsernameAvailability((String) jsonObject.get("username"));
    }

    // Returns true or false depending on username availability.
    // If username is in use returns true.
    public boolean checkForUsernameAvailability(String name) {
        List<Account> accountList = accountRepository.findAll();
        List<String> usernameCurrentList = accountList.stream()
                .map(Account::getUsername)
                .toList();
        return usernameCurrentList.contains(name);


    }


    // ===== Login =====
    // Username is check for present. If true, password is compared to the password
    // of the account. Returns a map with status and userId
    public Map<String, String> accountLogin(String data) {
        JSONObject jsonObject = new JSONObject(data);
        Map<String, String> map = new HashMap<>();
        accountRepository.findAccountByUsername((String) jsonObject.get("username"))
        .ifPresentOrElse(acc -> {
            if(acc.getPassword().equals(jsonObject.get("password"))) {
                map.put("status", "true");
                map.put("userId", String.valueOf(acc.getUser_profile().getId()));
            } else {
                map.put("status", "invalidPassword");
                map.put("userId", "");
            }
        }, () -> {
            map.put("status", "invalidUsername");
            map.put("userId", "");
        });
        return map;
    }
}
