package br.com.joao.postagems;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GloblalException {

    @ExceptionHandler
    public ResponseEntity<String> handleEx(Exception ex, WebRequest request){
        return new ResponseEntity<>("Fanha interna: " + ex.getMessage(), HttpStatus.OK);
    }

}
