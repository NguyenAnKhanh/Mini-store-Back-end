package com.funnycode.ministore.AccountAPI.service.impl;

import com.funnycode.ministore.AccountAPI.dto.*;
import com.funnycode.ministore.AccountAPI.entity.Account;
import com.funnycode.ministore.AccountAPI.repository.IAccountRepository;
import com.funnycode.ministore.AccountAPI.service.AccountService;
import com.funnycode.ministore.AccountAPI.util.mapper.AccountMapper;
import com.funnycode.ministore.Exception.NotFoundException;
import com.funnycode.ministore.Model.CustomError;
import com.funnycode.ministore.Util.JwtTokenUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountServiceImpl implements AccountService {
    IAccountRepository iAccountRepository;
    PasswordEncoder passwordEncoder;
    JwtTokenUtil jwtTokenUtil;
    @Override
    public ResponseAccountDTO createAccount(CreateAccountDTO createAccountDTO) {
        // chuyen dto qua entity vi thang` repo chi lam viec voi entity
        // ham` toAccount nhan vao cai DTO, tra ve 1 thang entity
        Account account = AccountMapper.toAccount(createAccountDTO);
        // ma hoa mat khau truoc khi luu vao db
        account.setPassword(passwordEncoder.encode(account.getPassword()));
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
        Optional<Account> accountOptional = iAccountRepository.findByUsername(username);
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
        Optional<Account> accountOptional = iAccountRepository.findByUsername(username);
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

    @Override
    public ResponseLoginDTO login(RequestLoginDTO requestLoginDTO) {
        // lay account theo username
        Account account = iAccountRepository.findByUsername(requestLoginDTO.getUsername())
                .orElseThrow(()->new RuntimeException("Account not found"));

        // kiem tra password
        boolean isAuthentication = passwordEncoder
                .matches(requestLoginDTO.getPassword(), account.getPassword());
        if (!isAuthentication){
            throw new RuntimeException("Username or password is incorrect");
        }
        // ok thi gen ra token
        final int ONE_DAY = 24 * 60 * 60;
        String accessToken = jwtTokenUtil.generateToken(AccountMapper.toTokenPayload(account), ONE_DAY);

        // tra ve ng dung access
        return ResponseLoginDTO.builder()
                .account(AccountMapper.toResponseAccountDTO(account))
                .accessToken(accessToken)
                .build();
    }


}
