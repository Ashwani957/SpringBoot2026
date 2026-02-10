package com.snipper.springConditionOnProperty.Controller;


import com.snipper.springConditionOnProperty.Entity.ExceptionHandling;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalHandlerException {

//    Here we handle the ExceptionHandling if we handle the exception Here then it should not be
        @ExceptionHandler(ExceptionHandling.class)

    public String handleProductNotFoundException(ExceptionHandling exception){
             return "error";
    }

//    we can handle mulitple exception as we wish

}
