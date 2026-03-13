package dev.rayh.cardstore.entity;

import java.util.UUID;

import dev.rayh.cardstore.domain.card.types.AbilityType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AbilityEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String text;
    @Enumerated(EnumType.STRING)
    private AbilityType type;

}
