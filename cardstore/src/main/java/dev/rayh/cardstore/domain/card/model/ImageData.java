package dev.rayh.cardstore.domain.card.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class ImageData {
    private String small;
    private String large;
}
