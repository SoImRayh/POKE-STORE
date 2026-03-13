package dev.rayh.cardstore.domain.dto;

public record NewAccountDto(
        String email,
        String password,
        String confirmPassword,
        String firstName,
        String lastName
) {
}
