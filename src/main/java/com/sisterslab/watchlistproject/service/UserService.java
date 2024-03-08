package com.sisterslab.watchlistproject.service;

import com.sisterslab.watchlistproject.converter.UserConverter;
import com.sisterslab.watchlistproject.dto.request.UserRequestDto;
import com.sisterslab.watchlistproject.dto.response.AccountResponse;
import com.sisterslab.watchlistproject.dto.response.UserResponse;
import com.sisterslab.watchlistproject.model.Account;
import com.sisterslab.watchlistproject.model.User;
import com.sisterslab.watchlistproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    public List<UserResponse> saveUser(List<UserRequestDto> requestList) {
        List<User> userList = new ArrayList<>();
        for (UserRequestDto request : requestList) {
            User user = userConverter.toEntity(request);
            userList.add(user);
        }
        List<User> savedUser = userRepository.saveAll(userList);
        List<UserResponse> responseList = new ArrayList<>();
        for (User sarjIstasyon : savedUser) {
            responseList.add(userConverter.toResponse(sarjIstasyon));
        }
        return responseList;
    }

    public UserResponse getById(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        User user = optUser.orElseThrow(()->new RuntimeException("Id bulunamadi"));
        return userConverter.toResponse(user);
    }

    public List<UserResponse> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userConverter :: toResponse)
                .collect(Collectors.toList());
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Girdiğiniz Id de kulanıcı bulunamadı"));
        userRepository.deleteById(id);
    }

    public void deleteByName(String name) {
        if (Objects.isNull(name)){
            throw new RuntimeException("Silinecek kullanıcının adını giriniz!");
        }
        else{
            User user = userRepository.findByName(name);
            userRepository.delete(user);
        }
    }

    public UserResponse updateUser(Long id, UserRequestDto dto) {
        User watcher = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Id bulunadi"));
        watcher.setPassword(dto.getPassword());

        return userConverter
                .toResponse(userRepository.save(watcher));
    }

    public UserResponse updateAccountId(Long userId, AccountResponse response) {
        User theReal = userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("Id bulunadi"));
        Account account = new Account();
        account.setId(response.getId());
        theReal.setAccounts((List<Account>) account);

        return userConverter.toResponse(userRepository.save(theReal));
    }
}
