package dev.rayh.cardstore.entity;

import java.util.List;
import java.util.UUID;

import dev.rayh.cardstore.domain.card.types.Type;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
@Entity
public class AttackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private int damage;
    private String text;
    private int convertedEnergyCost;
    @Column(columnDefinition = "jsonb")
    private List<Type> cost;
}
