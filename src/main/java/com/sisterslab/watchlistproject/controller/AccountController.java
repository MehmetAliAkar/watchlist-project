package com.sisterslab.watchlistproject.controller;

import com.sisterslab.watchlistproject.core.endpoints.BaseEndpoints;
import com.sisterslab.watchlistproject.dto.request.AccountRequestDto;
import com.sisterslab.watchlistproject.dto.response.AccountResponse;
import com.sisterslab.watchlistproject.service.AccountService;
import com.sisterslab.watchlistproject.shared.endpoints.AccountEndpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AccountEndpoints.ACCOUNTS)
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @PostMapping
    public List<AccountResponse> save(@RequestBody List<AccountRequestDto> dto){
        return accountService.save(dto);
    }

    @GetMapping
    public List<AccountResponse> getAll(){
        return accountService.getAll();
    }

    @DeleteMapping("/name")
    public void deleteByName(@RequestParam String name){
        accountService.deleteByName(name);
    }
    @PutMapping("/{id}")
    public AccountResponse updateAccount(@PathVariable Long id, @RequestBody AccountRequestDto dto){
        return accountService.updateAccount(id, dto);
    }
}