package com.funnycode.ministore.AccountAPI.controller;

import com.funnycode.ministore.AccountAPI.entity.Account;

// Service -> interface de bot bi tight coupling
// Service interface se giao tiep qua thang serviceimpl
public interface AccountService {
    Account createAccount(Account account);
}
