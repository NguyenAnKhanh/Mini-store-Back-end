package com.funnycode.ministore.AccountAPI.service.impl;

import com.funnycode.ministore.AccountAPI.dto.CreateAccountDTO;
import com.funnycode.ministore.AccountAPI.dto.ResponseAccountDTO;
import com.funnycode.ministore.AccountAPI.entity.Account;
import com.funnycode.ministore.AccountAPI.repository.IAccountRepository;
import com.funnycode.ministore.AccountAPI.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final IAccountRepository iAccountRepository;

    @Override
    public ResponseAccountDTO createAccount(CreateAccountDTO createAccountDTO) {
        // chuyen dto qua entity vi thang` repo chi lam viec voi entity
        Account account = Account.builder()
                .username(createAccountDTO.getUsername())
                .password(createAccountDTO.getPassword())
                .build();
        account = iAccountRepository.save(account);

        //map tu entity -> DTO de gui cho controller
        ResponseAccountDTO response = ResponseAccountDTO.builder()
                .username(account.getUsername()).build();

        return response;
    }

    @Override
    public List<ResponseAccountDTO> getAllAccounts() {
        //list lay tu entity
        List<Account> accountList = iAccountRepository.findAll();
        //list dto, lay account tu trong list entity, sau do tra ve 1 list dto
        List<ResponseAccountDTO> responseAccountDTOList = new ArrayList<>();
        for (Account acc : accountList
        ) {
            responseAccountDTOList.add(ResponseAccountDTO.builder()
                    .username(acc.getUsername()).build());
        }
        return responseAccountDTOList;
    }
}
