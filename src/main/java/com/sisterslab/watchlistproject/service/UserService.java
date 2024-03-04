package com.sisterslab.watchlistproject.service;

import com.sisterslab.watchlistproject.dto.request.UserRequestDto;
import com.sisterslab.watchlistproject.dto.response.UserResponse;
import com.sisterslab.watchlistproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public UserResponse saveUser(UserRequestDto dto) {

    }
}
