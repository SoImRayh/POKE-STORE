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
    private Boolean isEmailVerified;
    private Boolean isSmartPhoneVerified;
    private LocalDateTime createdAt;

    public void setDefaultAccount(){
        setCreatedAt(LocalDateTime.now());
        setId(UUID.randomUUID());;
        setRole(AccountRole.USER);
        setIsEmailVerified(false);
        setIsSmartPhoneVerified(false);
        setIsActive(false);
    }

}


