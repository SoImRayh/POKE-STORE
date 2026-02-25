package dev.rayh.cardstore.controller;

import dev.rayh.cardstore.domain.dto.NewAccountDto;
import dev.rayh.cardstore.domain.dto.NewClientDto;
import dev.rayh.cardstore.service.imp.AccountServiceImpl;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountServiceImpl service;
    @PostMapping("/new")
    public ResponseEntity createNewAccount(@RequestBody NewAccountDto data){
        return service.createNewAccount(data);
    }
}
