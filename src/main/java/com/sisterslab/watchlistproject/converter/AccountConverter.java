package com.sisterslab.watchlistproject.converter;

import com.sisterslab.watchlistproject.dto.request.AccountRequestDto;
import com.sisterslab.watchlistproject.dto.response.AccountResponse;
import com.sisterslab.watchlistproject.model.Account;
import com.sisterslab.watchlistproject.model.User;
import org.springframework.stereotype.Component;


@Component
public class AccountConverter {
    public AccountResponse toResponse(Account entity){
        AccountResponse response = new AccountResponse();
        response.setId(entity.getId());
        //buraya userId
        response.setCreatedDate(entity.getCreatedDate());
        response.setUpdatedDate(entity.getUpdatedDate());
        response.setName(entity.getName());
        response.setPuan(entity.getPuan());
        response.setDescription(entity.getDescription());
        //response.setPublicationDate(entity.getPublicationDate());

        return response;
    }

    public Account toEntity(AccountRequestDto dto){
        Account account = new Account();
        account.setName(dto.getName());
        account.setPuan(dto.getPuan());
        account.setDescription(dto.getDescription());

        /*User user = new User();
        user.setId(dto.getUserId());*/

        //account.setUsers(Collections.singletonList(user));
        return account;
    }
}
