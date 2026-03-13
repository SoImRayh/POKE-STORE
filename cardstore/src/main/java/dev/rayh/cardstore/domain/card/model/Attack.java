package dev.rayh.cardstore.domain.card.model;

import java.util.List;

import dev.rayh.cardstore.domain.card.types.Type;
import lombok.Data;

@Data
public class Attack {
    private String name;
    private String damage;
    private String text;
    private Integer convertedEnergyCost;
    private List<Type> cost;
}
