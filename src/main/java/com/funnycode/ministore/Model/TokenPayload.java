package com.funnycode.ministore.Model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TokenPayload {
    int accountID;
    String username;
}
