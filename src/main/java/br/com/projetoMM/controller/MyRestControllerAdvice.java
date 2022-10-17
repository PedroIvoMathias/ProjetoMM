package br.com.projetoMM.controller;

import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import br.com.projetoMM.exception.Error;
import org.springframework.web.bind.annotation.RestController;

@RestControllerAdvice(annotations = RestController.class)
public class MyRestControllerAdvice {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity erroPadrao(Exception e,HttpServletRequest request){
        Error error = new Error(Calendar.getInstance(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), e.getMessage(),request.getRequestURI());
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
