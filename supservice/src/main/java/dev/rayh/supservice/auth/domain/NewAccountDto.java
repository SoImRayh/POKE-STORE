package dev.rayh.supservice.auth.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record NewAccountDto(
        @Email
        String email,
        @NotNull
        String password,
        String confirmPassword,
        String firstName,
        String lastName
) {

}
