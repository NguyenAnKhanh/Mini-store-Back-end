package com.funnycode.ministore.Exception;

import com.funnycode.ministore.Model.CustomError;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotFoundException extends RuntimeException{
    CustomError customError;

    public NotFoundException(CustomError customError){
        this.customError = customError;
    }
}
