package dev.rayh.cardstore.domain.card.deck;

import dev.rayh.cardstore.domain.card.entity.CardEntity;
import dev.rayh.cardstore.domain.card.types.SubType;
import dev.rayh.cardstore.domain.card.types.Type;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "decks")
public class DeckEntity {

    @Id
    private String id;
    private String name;
    @JdbcTypeCode(SqlTypes.JSON)
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "jsonb")
    private List<Type> types;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<DeckCard> cards;
}
