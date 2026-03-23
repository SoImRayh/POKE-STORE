package dev.rayh.supservice.auth.service;

import dev.rayh.supservice.auth.domain.LoginRequest;
import dev.rayh.supservice.auth.domain.NewAccountDto;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity register(NewAccountDto dto);

    ResponseEntity<String> login(LoginRequest request);
}
