package dev.rayh.cardstore.controller;

import dev.rayh.cardstore.domain.account.Account;
import dev.rayh.cardstore.domain.dto.NewAccountDto;
import dev.rayh.cardstore.service.imp.AccountServiceImpl;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountServiceImpl service;
    @PostMapping("/create")
    public ResponseEntity createNewAccount(@RequestBody NewAccountDto data){
        return service.createNewAccount(data);
    }

    @PostMapping("/send-email")
        public ResponseEntity sendEmail(@RequestBody NewAccountDto data){
            return service.sendEmailOfVerification(data);
        }

    @GetMapping("/verify")
    public ResponseEntity verifyEmailAccount( @RequestParam String verificationID ){
        return service.verifyAndActivateAccount(verificationID);
    }

    @PutMapping("/delete")
    public ResponseEntity deleteAccount(@PathVariable String email){
        return service.deleteAccount(email);
    }

    @PutMapping("/update")
    public ResponseEntity updateAccount(@PathVariable UUID id, @RequestBody Account account){
        return service.updateAccount(id, account);
    }

}
