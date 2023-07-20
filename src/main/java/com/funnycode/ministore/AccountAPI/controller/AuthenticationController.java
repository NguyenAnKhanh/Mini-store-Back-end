package com.funnycode.ministore.AccountAPI.controller;

import com.funnycode.ministore.AccountAPI.dto.RequestLoginDTO;
import com.funnycode.ministore.AccountAPI.dto.ResponseLoginDTO;
import com.funnycode.ministore.AccountAPI.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AccountService accountService;

    @PostMapping("/login")
    public ResponseLoginDTO login(@RequestBody RequestLoginDTO requestLoginDTO){
        return accountService.login(requestLoginDTO);
    }

}
