package com.sisterslab.watchlistproject.controller;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.sisterslab.watchlistproject.core.endpoints.BaseEndpoints;
import com.sisterslab.watchlistproject.model.User;
import com.sisterslab.watchlistproject.repository.AccountRepository;
import com.sisterslab.watchlistproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(BaseEndpoints.BASE+"/account/user")
@RequiredArgsConstructor
public class AccountUserController {
    private UserRepository userRepository;
    private AccountRepository accountRepository;

    @PostMapping
    public User saveStudentWithAccount(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findUser(Long id){
        return userRepository.findById(id).orElse(null);
    }
}
