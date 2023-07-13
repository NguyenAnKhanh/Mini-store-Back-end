package com.funnycode.ministore.AccountAPI.service;

import com.funnycode.ministore.AccountAPI.dto.CreateAccountDTO;
import com.funnycode.ministore.AccountAPI.dto.ResponseAccountDTO;
import com.funnycode.ministore.AccountAPI.dto.UpdateAccountDTO;
import com.funnycode.ministore.AccountAPI.entity.Account;

import java.util.List;

// Service -> interface de bot bi tight coupling
// Service interface se giao tiep qua thang serviceimpl
public interface AccountService {
    ResponseAccountDTO createAccount(CreateAccountDTO createAccountDTO);

    List<ResponseAccountDTO> getAllAccounts();

    ResponseAccountDTO getAccountByUsername(String username);

    ResponseAccountDTO updateAccount(UpdateAccountDTO updateAccountDTO, String username);

    ResponseAccountDTO deleteAccount(String username);
}
