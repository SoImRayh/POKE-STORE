package dev.rayh.cardstore.domain.card.deck;

public record DeckCard(
        String id,
        String name,
        String rarity,
        int count
) {
}
