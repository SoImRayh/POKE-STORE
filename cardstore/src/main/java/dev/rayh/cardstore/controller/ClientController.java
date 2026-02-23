package dev.rayh.cardstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rayh.cardstore.domain.account.Client;
import dev.rayh.cardstore.service.ClientService;
import dev.rayh.cardstore.service.imp.ClientServiceImp;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@RequestMapping("/clients")
@RestController
public class ClientController {

    private final ClientServiceImp service;

    @PostMapping("/new")
    public ResponseEntity saveOne(@RequestBody Client entity) {
        
        return service.createOne(entity);
    }
    

}
