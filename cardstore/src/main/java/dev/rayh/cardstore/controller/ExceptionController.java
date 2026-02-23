package dev.rayh.cardstore.controller;

import dev.rayh.cardstore.domain.CPForCNPJInvalidException;
import dev.rayh.cardstore.domain.dto.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = CPForCNPJInvalidException.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity handleCPForCNPJInvalidException(
            CPForCNPJInvalidException e,
            HttpServletRequest request){


        var dto = new ErrorResponseDto(
                LocalDateTime.now().toString(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                request.getRequestURI());

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
