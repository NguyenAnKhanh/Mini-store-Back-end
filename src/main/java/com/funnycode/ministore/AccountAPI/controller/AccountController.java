package com.funnycode.ministore.AccountAPI.controller;

import com.funnycode.ministore.AccountAPI.dto.CreateAccountDTO;
import com.funnycode.ministore.AccountAPI.dto.ResponseAccountDTO;
import com.funnycode.ministore.AccountAPI.entity.Account;
import com.funnycode.ministore.AccountAPI.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/accounts")
    //@RequestBody de lay cai param dc truyen vao tu phan body cua request dc gui
    public ResponseAccountDTO createAccount(@RequestBody CreateAccountDTO createAccountDTO){
        return accountService.createAccount(createAccountDTO);
    }

    @GetMapping("/accounts")
    public List<ResponseAccountDTO> getAllAccounts(){
        return accountService.getAllAccounts();

    }
}
