package dev.rayh.cardstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "clients")
@Data
@NoArgsConstructor
public class ClientEntity {
    @Id
    private String cpfOrCnpj;
    @NonNull
    private String fantasyName;
    private String socialReason;
    private String email;
    private String phone;
}
