package com.funnycode.ministore.AccountAPI.util.mapper;

import com.funnycode.ministore.AccountAPI.dto.CreateAccountDTO;
import com.funnycode.ministore.AccountAPI.dto.ResponseAccountDTO;
import com.funnycode.ministore.AccountAPI.dto.UpdateAccountDTO;
import com.funnycode.ministore.AccountAPI.entity.Account;

public class AccountMapper {
    // nhan vao dto -> tra ve entity
    // su dung createDTO
    public static Account toAccount(CreateAccountDTO createAccountDTO) {
        return Account.builder()
                .username(createAccountDTO.getUsername())
                .password(createAccountDTO.getPassword())
                .build();
    }

    // nhan vao entity -> tra ve dto
    // dto k chua' password
    public static ResponseAccountDTO toResponseAccountDTO(Account account) {
        return ResponseAccountDTO.builder()
                .username(account.getUsername()).build();
    }

    public static Account toAccount(UpdateAccountDTO updateAccountDTO) {
        return Account.builder()
                .username(updateAccountDTO.getUsername())
                .password(updateAccountDTO.getPassword())
                .build();
    }
}