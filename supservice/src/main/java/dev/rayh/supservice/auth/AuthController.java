package dev.rayh.supservice.auth;

import dev.rayh.supservice.auth.domain.LoginRequest;
import dev.rayh.supservice.auth.domain.NewAccountDto;
import dev.rayh.supservice.auth.service.impl.AccountServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    public final AccountServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity registerAccount(@Valid @RequestBody NewAccountDto dto){
        return service.register(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        return service.login(request);
    }
}
