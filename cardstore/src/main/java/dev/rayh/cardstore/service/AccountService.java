package dev.rayh.cardstore.service;

import dev.rayh.cardstore.domain.dto.NewAccountDto;
import dev.rayh.cardstore.domain.dto.NewClientDto;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity createNewAccount(NewAccountDto dto);
}
