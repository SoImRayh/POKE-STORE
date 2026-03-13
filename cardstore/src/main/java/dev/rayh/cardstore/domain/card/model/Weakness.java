package dev.rayh.cardstore.domain.card.model;

import dev.rayh.cardstore.domain.card.types.Type;
import lombok.Data;

@Data
public class Weakness {
    private Type type;
    private String value;
}
