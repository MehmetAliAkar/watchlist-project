package com.sisterslab.watchlistproject.service;

import com.sisterslab.watchlistproject.converter.AccountConverter;
import com.sisterslab.watchlistproject.dto.request.AccountRequestDto;
import com.sisterslab.watchlistproject.dto.request.UserRequestDto;
import com.sisterslab.watchlistproject.dto.response.AccountResponse;
import com.sisterslab.watchlistproject.dto.response.UserResponse;
import com.sisterslab.watchlistproject.model.Account;
import com.sisterslab.watchlistproject.model.User;
import com.sisterslab.watchlistproject.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountConverter accountConverter;
    private final UserService userService;

    public List<AccountResponse> save(List<AccountRequestDto> requestList) {
        List<Account> accountList = new ArrayList<>();
        for(AccountRequestDto request : requestList){
            Account account = accountConverter.toEntity(request);
            accountList.add(account);
        }
        List<Account> savedAccount = accountRepository.saveAll(accountList);
        List<AccountResponse> responseList = new ArrayList<>();
        for(Account account : savedAccount){
            responseList.add(accountConverter.toResponse(account));
        }
        return responseList;
    }

    public List<AccountResponse> getAll() {
        return accountRepository
                .findAll()
                .stream()
                .map(accountConverter :: toResponse)
                .collect(Collectors.toList());
    }
    public void deleteByName(String name) {
        if (Objects.isNull(name)){
            throw new RuntimeException("Silinecek filmin adını giriniz!");
        }
        else{
            Account account = accountRepository.findByName(name);
            accountRepository.delete(account);
        }
    }

    public AccountResponse updateAccount(Long id, AccountRequestDto dto) {
        Account theRealAccount = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Id bulunadi"));
        theRealAccount.setName(dto.getName());
        theRealAccount.setDescription(dto.getDescription());
        theRealAccount.setPuan(dto.getPuan());

        return accountConverter
                .toResponse(accountRepository.save(theRealAccount));
    }

}
