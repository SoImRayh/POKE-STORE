package dev.rayh.cardstore.service;

import dev.rayh.cardstore.domain.account.Account;
import dev.rayh.cardstore.domain.dto.NewAccountDto;
import dev.rayh.cardstore.domain.dto.NewClientDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface AccountService {
    ResponseEntity createNewAccount(NewAccountDto dto);

    ResponseEntity deleteAccount(UUID id);

    ResponseEntity updateAccount(UUID id, Account account);
}
