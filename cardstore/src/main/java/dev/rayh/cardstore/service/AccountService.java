package dev.rayh.cardstore.service;

import dev.rayh.cardstore.domain.account.Account;
import dev.rayh.cardstore.domain.dto.NewAccountDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface AccountService {
    ResponseEntity createNewAccount(NewAccountDto dto);

    ResponseEntity deleteAccount(String email);

    ResponseEntity updateAccount(UUID id, Account account);

    ResponseEntity verifyAndActivateAccount(String requestId);

    ResponseEntity sendEmailOfVerification(NewAccountDto data);
}
