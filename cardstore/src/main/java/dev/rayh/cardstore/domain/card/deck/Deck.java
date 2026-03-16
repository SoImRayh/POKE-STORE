package dev.rayh.cardstore.domain.card.deck;

import dev.rayh.cardstore.domain.card.model.Card;
import dev.rayh.cardstore.domain.card.types.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Deck {
    private final int MAX_CARD_QUANTITY = 60;

    private String id;
    private String name;
    private List<Type> types;
    private List<DeckCard> cards = new ArrayList<>(MAX_CARD_QUANTITY);


}
