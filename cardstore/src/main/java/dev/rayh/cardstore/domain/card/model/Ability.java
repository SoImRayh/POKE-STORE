package dev.rayh.cardstore.domain.card.model;

import dev.rayh.cardstore.domain.card.types.AbilityType;
import lombok.Data;

@Data
public class Ability {
    private String name;
    private String text;
    private AbilityType type;
}
