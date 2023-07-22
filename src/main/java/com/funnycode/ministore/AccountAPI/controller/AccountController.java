package com.funnycode.ministore.AccountAPI.controller;

import com.funnycode.ministore.AccountAPI.dto.CreateAccountDTO;
import com.funnycode.ministore.AccountAPI.dto.ResponseAccountDTO;
import com.funnycode.ministore.AccountAPI.dto.UpdateAccountDTO;
import com.funnycode.ministore.AccountAPI.entity.Account;
import com.funnycode.ministore.AccountAPI.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.funnycode.ministore.Util.Constant.API_VERSION;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_VERSION)

public class AccountController {
    private final AccountService accountService;

    // Create
    @PostMapping("/accounts")
    //@RequestBody de lay cai param dc truyen vao tu phan body cua request dc gui
    public ResponseAccountDTO createAccount(@RequestBody CreateAccountDTO createAccountDTO){
        return accountService.createAccount(createAccountDTO);
    }

    // Get list account
    @GetMapping("/accounts")
    public List<ResponseAccountDTO> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    // Get account based on id
    @GetMapping("/accounts/{username}")
    public ResponseAccountDTO getAccountByUsername(@PathVariable(name = "username") String username){
        return accountService.getAccountByUsername(username);
    }

    @PutMapping("/accounts/{username}")
    public ResponseAccountDTO updateAccount(@RequestBody UpdateAccountDTO updateAccountDTO, @PathVariable(name = "username") String username){
        return accountService.updateAccount(updateAccountDTO, username);
    }

    @DeleteMapping("accounts/{username}")
    public ResponseAccountDTO deleteAccount(@PathVariable(name = "username") String username){
        return accountService.deleteAccount(username);
    }

}
