package dev.rayh.supservice.general;

import dev.rayh.supservice.auth.exception.NewAccountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NewAccountException.class)
    public ResponseEntity<ErrorResponseDto> handleWhenNewAccountExceptionIsThrew(NewAccountException e){
        var error = new ErrorResponseDto(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
