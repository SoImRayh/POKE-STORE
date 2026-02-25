package dev.rayh.cardstore.entity;

import dev.rayh.cardstore.domain.account.AccountRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "accounts")
public class AccountEntity {

    @Id
    private UUID id;
    @Email
    @Column( unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AccountRole role;
    private Boolean isActive;
    private LocalDateTime createdAt;


}
