package dev.rayh.cardstore.domain.card.model;


import java.util.List;
import java.util.Objects;

import dev.rayh.cardstore.domain.card.set.Set;
import dev.rayh.cardstore.domain.card.types.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String id;
    private String name;
    private SuperType supertype;
    private List<SubType> subtypes;
    private String hp;
    private List<Type> types;
    private List<String> evolvesTo;
    private String evolvesFrom;
    private List<Ability> abilities;
    private List<Attack> attacks;
    private List<Weakness> weaknesses;
    private List<Type> retreatCost;
    private Integer convertedRetreatCost;
    private String number;
    private String artist;
    private String rarity;
    private String flavorText;
    private List<Integer> nationalPokedexNumbers;
    private Legality legalities;
    private String regulationMark;
    private ImageData images;
    private Set set;

    @Override
    public boolean equals(Object o ){
        Card c;

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        c = (Card) o;
        return id.equals(c.getId());
    }
}
