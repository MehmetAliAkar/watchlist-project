package com.sisterslab.watchlistproject.controller;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.sisterslab.watchlistproject.core.endpoints.BaseEndpoints;
import com.sisterslab.watchlistproject.model.AccountUser;
import com.sisterslab.watchlistproject.repository.AccountUserRepository;
import com.sisterslab.watchlistproject.service.AccountUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(BaseEndpoints.BASE+"/accountuser")
@RequiredArgsConstructor
public class AccountUserController {
    private final AccountUserService accountUserService;

    @GetMapping
    public List<AccountUser> getAll(){
        return accountUserService.getAll();
    }
}
