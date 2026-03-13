package dev.rayh.cardstore.domain.card.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
public class Legality {
    private String standard;
    private String unlimited;
    private String expanded;

}
