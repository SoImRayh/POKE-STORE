package dev.rayh.cardstore.domain.card.entity;

import dev.rayh.cardstore.domain.card.IntegerListConverter;
import dev.rayh.cardstore.domain.card.StringListConverter;
import dev.rayh.cardstore.domain.card.model.*;
import dev.rayh.cardstore.domain.card.types.SubType;
import dev.rayh.cardstore.domain.card.types.SuperType;
import dev.rayh.cardstore.domain.card.types.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "cards")
public class CardEntity {
    @Id
    private String id;
    private String name;
    private SuperType supertype;

    @JdbcTypeCode(SqlTypes.JSON)
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "jsonb")
    private List<SubType> subtypes;
    private String hp;

    @JdbcTypeCode(SqlTypes.JSON)
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "jsonb")
    private List<Type> types;

    @Convert(converter = StringListConverter.class)
    private List<String> evolvesTo;
    private String evolvesFrom;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<Ability> abilities;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<Attack> attacks;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<Weakness> weaknesses;
    @JdbcTypeCode(SqlTypes.JSON)
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "jsonb")
    private List<Type> retreatCost;

    @Column(columnDefinition = "integer default 0")
    private Integer convertedRetreatCost;
    private String number;
    private String artist;
    private String rarity;
    private String flavorText;
    @Convert(converter = IntegerListConverter.class)
    private List<Integer> nationalPokedexNumbers;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Legality legalities;
    private String regulationMark;
    @Embedded
    private ImageData images;

    @PrePersist
    public void prePersist(){
        if (this.convertedRetreatCost == null)
            this.convertedRetreatCost = 0;
    }
}
