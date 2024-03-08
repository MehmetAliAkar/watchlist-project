package com.sisterslab.watchlistproject.service;

import com.sisterslab.watchlistproject.converter.AccountConverter;
import com.sisterslab.watchlistproject.dto.request.AccountRequestDto;
import com.sisterslab.watchlistproject.dto.response.AccountResponse;
import com.sisterslab.watchlistproject.model.Account;
import com.sisterslab.watchlistproject.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountConverter accountConverter;
    private final UserService userService;

    public AccountResponse save(AccountRequestDto dto) {
        Account entity = accountConverter.toEntity(dto);
        AccountResponse response = accountConverter.toResponse(
                accountRepository.save(entity));
        userService.updateAccountId(dto.getUserId(), response);
        return response;
    }
}
