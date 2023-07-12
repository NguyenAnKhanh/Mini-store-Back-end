package com.funnycode.ministore.AccountAPI.controller;

import com.funnycode.ministore.AccountAPI.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/accounts")
    //@RequestBody de lay cai param dc truyen vao tu phan body cua request dc gui
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }
}
