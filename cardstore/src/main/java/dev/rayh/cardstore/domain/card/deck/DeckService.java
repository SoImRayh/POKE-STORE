package dev.rayh.cardstore.domain.card.deck;

import org.springframework.http.ResponseEntity;

public interface DeckService {
    ResponseEntity saveOne(Deck deck);

    ResponseEntity getAll();
}
