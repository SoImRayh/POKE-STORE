package dev.rayh.cardstore.controller;

import dev.rayh.cardstore.domain.account.Account;
import dev.rayh.cardstore.domain.dto.NewAccountDto;
import dev.rayh.cardstore.service.imp.AccountServiceImpl;


import dev.rayh.contracts.EmailEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountServiceImpl service;
    private final KafkaTemplate<String, EmailEvent> kafkaTemplate;
    @PostMapping("/new")
    public ResponseEntity createNewAccount(@RequestBody NewAccountDto data){
        return service.createNewAccount(data);
    }

    @PutMapping("/delete")
    public ResponseEntity deleteAccount(@PathVariable UUID id){
        return service.deleteAccount(id);
    }

    @PutMapping("/update")
    public ResponseEntity updateAccount(@PathVariable UUID id, @RequestBody Account account){
        return service.updateAccount(id, account);
    }
    @PostMapping("/test")
    public ResponseEntity teste(@RequestBody EmailEvent event){

        System.out.println(event);
            kafkaTemplate.send("email", event);

            return ResponseEntity.ok(null);
    }
}
