package com.testback.exception.handler;

import com.testback.exception.CandidateNotFoundException;
import com.testback.message.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CandidateNotFoundException.class)
    public ResponseEntity<ResponseMessage> directoryNotFoundException(CandidateNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseMessage.builder()
                        .message(exception.getMessage()).build());
    }
}
