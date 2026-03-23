package dev.rayh.supservice.auth.domain;

public record LoginRequest(
        String email,
        String password
) {
}
