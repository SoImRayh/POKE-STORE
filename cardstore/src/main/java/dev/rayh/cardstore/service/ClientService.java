package dev.rayh.cardstore.service;

import org.springframework.http.ResponseEntity;

import dev.rayh.cardstore.domain.account.Client;

public interface ClientService {
    ResponseEntity createOne(Client c);
}
