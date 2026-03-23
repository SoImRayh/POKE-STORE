package dev.rayh.supservice.auth.service.impl;

import dev.rayh.supservice.auth.domain.*;
import dev.rayh.supservice.auth.exception.LoginRequestException;
import dev.rayh.supservice.auth.exception.NewAccountException;
import dev.rayh.supservice.auth.repo.UserCredentialsRepository;
import dev.rayh.supservice.auth.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserCredentialsRepository repository;
    private final PasswordEncoder encoder;
    private final JwtServiceImpl jwtService;

    @Override
    public ResponseEntity register(NewAccountDto dto) {
        UserCredentials model;

//        create credential -> new Kafka event to create user

        final String FROM_EMAIL= "raykah.silva@gmail.com";

        //verifying if passwords matches
        if ( !dto.password().equals(dto.confirmPassword()) )
            throw new NewAccountException("Passwords doesnt matches");

        //verifying if email already exists in database
        if (repository.existsByEmail(dto.email()))
            throw new NewAccountException("this email already exists");

        model = UserCredentialsFactory.modelFrom(dto);
        //setting as default account and save in database
        try {
            model.getRoles().add(AccountRole.USER);
            //hashing and updating the password
            //TODO implement hashing here and post a event on kafka to create new user_profile on api-resource db.
            model.setPassword(encoder.encode(model.getPassword()));
            repository.save(UserCredentialsFactory.entityFrom(model));

            //sendEmail(model.getEmail());

            return new ResponseEntity(model, HttpStatus.OK);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //return null;
    }

    @Override
    public ResponseEntity<String> login(LoginRequest request) {
        System.out.println(encoder.encode(request.password()));
        var user = repository.findByEmail(request.email()).orElseThrow(
                () -> new LoginRequestException("User not found!"));
        if(encoder.matches(request.password(), user.getPassword())) {
            return new ResponseEntity<>(jwtService.createNewToken(UserCredentialsFactory.modelFrom(user)), HttpStatus.OK );
        }
        return null;
    }
}
