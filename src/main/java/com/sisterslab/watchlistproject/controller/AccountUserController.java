package com.sisterslab.watchlistproject.controller;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.sisterslab.watchlistproject.converter.UserConverter;
import com.sisterslab.watchlistproject.core.endpoints.BaseEndpoints;
import com.sisterslab.watchlistproject.dto.response.UserResponse;
import com.sisterslab.watchlistproject.model.Film;
import com.sisterslab.watchlistproject.model.User;
import com.sisterslab.watchlistproject.repository.FilmRepository;
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
    private FilmRepository accountRepository;
    private UserConverter userConverter;

    @PostMapping
    public User saveUserWithAccount(@RequestBody User user){
        return  userRepository.save(user);
    }

    @GetMapping
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findUser(@RequestBody Long id){
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/{filmId}/users/{userId}")
    public User enrolledFilmsToUser(
            @PathVariable Long userId, @PathVariable Long filmId){
        User user = userRepository.findById(userId).get();
        Film film = accountRepository.findById(filmId).get();
        user.enrollFilm(film);
        return userRepository.save(user);
    }
}
