package com.sisterslab.watchlistproject.controller;

import com.sisterslab.watchlistproject.core.endpoints.BaseEndpoints;
import com.sisterslab.watchlistproject.dto.request.AccountRequestDto;
import com.sisterslab.watchlistproject.dto.response.AccountResponse;
import com.sisterslab.watchlistproject.service.AccountService;
import com.sisterslab.watchlistproject.shared.endpoints.AccountEndpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AccountEndpoints.ACCOUNTS)
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @PostMapping
    public AccountResponse save (@RequestBody AccountRequestDto dto){
        return accountService.save(dto);
    }

}
