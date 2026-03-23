package dev.rayh.supservice.auth.domain;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class UserCredentials {
    private UUID id;
    private String email;
    private String password;
    private boolean isActive;
    private Set<AccountRole> roles;
}
