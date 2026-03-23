package dev.rayh.supservice.auth.service;

import dev.rayh.supservice.auth.domain.UserCredentials;

public interface JwtService {
    String createNewToken(UserCredentials user);
    String renewToken();
}
