package dev.rayh.cardstore.domain.card.deck;

import dev.rayh.cardstore.domain.card.types.Type;

import java.util.List;

public record DeckDto(
        String id,
        String name,
        List<Type>types,
        List<DeckCard> cards
) {
}
