package dev.rayh.cardstore.domain.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;





@Data
@NoArgsConstructor
public class Account {

    private String firstName;
    private String lastName;
    private UUID id;
    private String email;
    private String password;
    private AccountRole role;
    private Boolean isActive;
    private LocalDateTime createdAt;


}


