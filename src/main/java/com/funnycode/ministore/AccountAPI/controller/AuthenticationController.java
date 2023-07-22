package com.funnycode.ministore.AccountAPI.controller;

import com.funnycode.ministore.AccountAPI.dto.RequestLoginDTO;
import com.funnycode.ministore.AccountAPI.dto.ResponseLoginDTO;
import com.funnycode.ministore.AccountAPI.service.AccountService;
import com.funnycode.ministore.Util.Constant;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.funnycode.ministore.Util.Constant.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(API_VERSION)
public class AuthenticationController {
    AccountService accountService;

    @PostMapping("/login")
    public ResponseLoginDTO login(@RequestBody RequestLoginDTO requestLoginDTO){
        return accountService.login(requestLoginDTO);
    }

}
