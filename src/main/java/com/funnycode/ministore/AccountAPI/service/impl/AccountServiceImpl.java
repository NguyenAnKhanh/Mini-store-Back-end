package com.funnycode.ministore.AccountAPI.service.impl;

import com.funnycode.ministore.AccountAPI.dto.CreateAccountDTO;
import com.funnycode.ministore.AccountAPI.dto.ResponseAccountDTO;
import com.funnycode.ministore.AccountAPI.dto.UpdateAccountDTO;
import com.funnycode.ministore.AccountAPI.entity.Account;
import com.funnycode.ministore.AccountAPI.repository.IAccountRepository;
import com.funnycode.ministore.AccountAPI.service.AccountService;
import com.funnycode.ministore.AccountAPI.util.mapper.AccountMapper;
import com.funnycode.ministore.Exception.NotFoundException;
import com.funnycode.ministore.Model.CustomError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final IAccountRepository iAccountRepository;

    @Override
    public ResponseAccountDTO createAccount(CreateAccountDTO createAccountDTO) {
        // chuyen dto qua entity vi thang` repo chi lam viec voi entity
        // ham` toAccount nhan vao cai DTO, tra ve 1 thang entity
        Account account = AccountMapper.toAccount(createAccountDTO);
        account = iAccountRepository.save(account);

        //map tu entity -> DTO de gui cho controller

//        ResponseAccountDTO response = ResponseAccountDTO.builder()
//                .username(account.getUsername()).build();

        return AccountMapper.toResponseAccountDTO(account);
    }

    @Override
    public List<ResponseAccountDTO> getAllAccounts() {
        //list lay tu entity
        List<Account> accountList = iAccountRepository.findAll();
        //list dto, lay account tu trong list entity, sau do tra ve 1 list dto
        List<ResponseAccountDTO> responseAccountDTOList = new ArrayList<>();
        for (Account acc : accountList
        ) {
            responseAccountDTOList.add(AccountMapper.toResponseAccountDTO(acc));
        }
        return responseAccountDTOList;
    }

    @Override
    public ResponseAccountDTO getAccountByUsername(String username) {
        Optional<Account> accountOptional = iAccountRepository.findById(username);
        if (accountOptional.isEmpty()) {
            throw new NotFoundException(CustomError.builder().message("Account not found!").code("404").build());
        } else {
            return AccountMapper.toResponseAccountDTO(accountOptional.get());

        }
    }

    @Override
    public ResponseAccountDTO updateAccount(UpdateAccountDTO updateAccountDTO, String username) {
        // map tu update sang account/entity
        Account account = AccountMapper.toAccount(updateAccountDTO);
        // phai set id/username cho no vi ham updateDTO chi thay doi password
        account.setUsername(username);
        account = iAccountRepository.save(account);
        // map tu entity ve dto de gui ve (response)
        return AccountMapper.toResponseAccountDTO(account);
    }

    @Override
    public ResponseAccountDTO deleteAccount(String username) {
        // lay thang entity tu thang` dto
        Optional<Account> accountOptional = iAccountRepository.findById(username);
        Account account = accountOptional
                .orElseThrow(() -> new NotFoundException(
                        CustomError
                                .builder()
                                .message("Account not found!")
                                .code("404").build()));
        // delete
        iAccountRepository.delete(account);
        // tra ve thang` dc xoa
        return AccountMapper.toResponseAccountDTO(account);
    }


}
