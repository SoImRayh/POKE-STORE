package dev.rayh.cardstore.domain.card.set;

import dev.rayh.cardstore.domain.card.entity.CardEntity;
import dev.rayh.cardstore.domain.card.model.Card;
import dev.rayh.cardstore.domain.card.model.Legality;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity(name = "sets")
@Data
@NoArgsConstructor
public class SetEntity {
    @Id
    private String id;
    private String name;
    private String series;
    private int printedTotal;
    private int total;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Legality legalities;
    private String ptcgoCode;
    private LocalDate releaseDate;
    private LocalDateTime updatedAt;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private ImageLink images;
    @OneToMany(mappedBy = "set")
    private List<CardEntity> cards;
}
