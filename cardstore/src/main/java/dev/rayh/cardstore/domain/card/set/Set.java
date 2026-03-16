package dev.rayh.cardstore.domain.card.set;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.rayh.cardstore.domain.card.model.Card;
import dev.rayh.cardstore.domain.card.model.Legality;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Set {
    private String id;
    private String name;
    private String series;
    private int printedTotal;
    private int total;
    private Legality legalities;
    private String ptcgoCode;
    private LocalDate releaseDate;
    private LocalDateTime updatedAt;
    private ImageLink images;
    private List<Card> cards;
}

