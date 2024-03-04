package com.sisterslab.watchlistproject.controller;

import com.sisterslab.watchlistproject.core.endpoints.BaseEndpoints;
import com.sisterslab.watchlistproject.dto.request.UserRequestDto;
import com.sisterslab.watchlistproject.dto.response.UserResponse;
import com.sisterslab.watchlistproject.service.UserService;
import com.sisterslab.watchlistproject.shared.endpoints.UserEndpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserEndpoints.USERS)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponse save(@RequestBody UserRequestDto dto){
        return userService.saveUser(dto);
    }
}
