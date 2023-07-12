package com.funnycode.ministore.AccountAPI.controller;

import com.funnycode.ministore.AccountAPI.entity.Account;
import com.funnycode.ministore.AccountAPI.repository.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final IAccountRepository iAccountRepository;

    @Override
    public Account createAccount(Account account) {
        return iAccountRepository.save(account);
    }
}
