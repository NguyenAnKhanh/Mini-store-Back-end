package com.funnycode.ministore.Exception;

import com.funnycode.ministore.Model.CustomError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // cach dung responseEntity thi linh dong hon trong viec tra ve ma~ loi
    // thu vien build san ma~ loi
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<CustomError> notFoundException(NotFoundException ex){
//        return ResponseEntity.internalServerError().body(ex.getCustomError());
//    }

    // not found exception
    @ExceptionHandler(NotFoundException.class)
    public CustomError notFoundException(NotFoundException ex){
        return ex.getCustomError();
    }

    // exception chung, chua dc xu li
    @ExceptionHandler(Exception.class)
    public CustomError internalServer(Exception ex){
         return CustomError.builder()
                 .code("500")
                 .message("Internal server error")
                 .build();
    }
}

