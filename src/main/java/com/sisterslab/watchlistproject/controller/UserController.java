package com.sisterslab.watchlistproject.controller;

import com.sisterslab.watchlistproject.core.endpoints.BaseEndpoints;
import com.sisterslab.watchlistproject.dto.request.UserRequestDto;
import com.sisterslab.watchlistproject.dto.response.UserResponse;
import com.sisterslab.watchlistproject.model.User;
import com.sisterslab.watchlistproject.service.UserService;
import com.sisterslab.watchlistproject.shared.endpoints.UserEndpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserEndpoints.USERS)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public List<UserResponse> createSarjList(@RequestBody List<UserRequestDto> requestList) {
        return userService.saveUser(requestList);
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @GetMapping
    public List<UserResponse> getAll(){
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @DeleteMapping("/name")
    public void deleteByName(@RequestParam String name){
        userService.deleteByName(name);
    }

    @PutMapping("/{id}")
    public UserResponse updatePassword(@PathVariable Long id, @RequestBody UserRequestDto dto){
        return userService.updateUser(id, dto);
    }
}
