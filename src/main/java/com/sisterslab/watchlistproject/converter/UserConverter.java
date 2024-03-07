package com.sisterslab.watchlistproject.converter;

import com.sisterslab.watchlistproject.dto.request.UserRequestDto;
import com.sisterslab.watchlistproject.dto.response.UserResponse;
import com.sisterslab.watchlistproject.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserResponse toResponse(User entity){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(entity.getId());
        userResponse.setUserName(entity.getUserName());
        userResponse.setName(entity.getName());
        userResponse.setPassword(entity.getPassword());
        userResponse.setEmail(entity.getEmail());
        userResponse.setCreatedDate(entity.getCreatedDate());
        userResponse.setUpdatedDate(entity.getUpdatedDate());
        return userResponse;
    }

    public User toEntity(UserRequestDto dto){
        User user = new User();
        user.setName(dto.getName());
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return user;
    }

}
