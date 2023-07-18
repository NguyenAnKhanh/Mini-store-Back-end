package com.funnycode.ministore.Exception;

import com.funnycode.ministore.Model.CustomError;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException{
    CustomError customError;

    public NotFoundException(CustomError customError){
        this.customError = customError;
    }
}
