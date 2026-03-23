package dev.rayh.supservice.auth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "user_credentials")
public class UserCredentialsEntity {
    @Id
    private String email;
    private String password;
    private boolean isActive;
    private Set<AccountRole> roles;
}
