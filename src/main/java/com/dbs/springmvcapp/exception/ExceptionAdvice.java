package com.dbs.springmvcapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public String handleSQLException(HttpServletRequest request, Exception ex){
        System.out.println("Came inside the error block .........");
        return "error_test";
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(HttpServletRequest request, Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
    }
}
