package com.doozy.user.error;

import com.doozy.user.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> userNotFoundException(UserNotFoundException e, WebRequest req){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorMessage> bookNotFoundException(BookNotFoundException e, WebRequest req){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(BookNotLikedException.class)
    public ResponseEntity<ErrorMessage> bookNotLikedException(BookNotLikedException e, WebRequest req){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

}
