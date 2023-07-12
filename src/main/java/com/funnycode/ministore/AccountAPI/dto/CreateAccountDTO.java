package com.funnycode.ministore.AccountAPI.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateAccountDTO {
    String username;
    String password;
}
