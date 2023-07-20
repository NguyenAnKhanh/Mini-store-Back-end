package com.funnycode.ministore.AccountAPI.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ResponseAccountDTO {
    int id;
    String username;
}
