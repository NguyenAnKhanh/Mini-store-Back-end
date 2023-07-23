package com.funnycode.ministore.Exception;

import com.funnycode.ministore.Model.CustomError;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MiniStoreException extends RuntimeException{
    HttpStatus status;
    CustomError customError;

    public static MiniStoreException notFoundException(String message){
        return MiniStoreException.builder()
                .status(HttpStatus.NOT_FOUND)
                .customError(CustomError.builder()
                        .code("404")
                        .message(message)
                        .build())
                .build();
    }

    public static MiniStoreException badRequest(String message){
        return MiniStoreException.builder()
                .status(HttpStatus.BAD_REQUEST)
                .customError(CustomError.builder()
                        .code("400")
                        .message(message)
                        .build())
                .build();
    }
}
