package dev.rayh.cardstore.domain.card.deck.impl;

import dev.rayh.cardstore.domain.card.deck.Deck;
import dev.rayh.cardstore.domain.card.deck.DeckFactory;
import dev.rayh.cardstore.domain.card.deck.DeckRepository;
import dev.rayh.cardstore.domain.card.deck.DeckService;
import dev.rayh.cardstore.exception.NoRecordFoundexception;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeckServiceImpl implements DeckService {
    private final DeckRepository repository;

    @Override
    public ResponseEntity saveOne(Deck deck) {
        var model = DeckFactory.modelFromEntity(repository.save(
                DeckFactory.entityFromModel(deck)
        ));

        return new ResponseEntity(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getAll() {
        var decks = repository.findAll().stream().map(DeckFactory::modelFromEntity).toList();
        return new ResponseEntity(decks, HttpStatus.OK);
    }

    public ResponseEntity getOne(String id) {
        var deck = repository.findById(id).orElseThrow(() -> new NoRecordFoundexception("Not Found"));
        return new ResponseEntity(deck, HttpStatus.OK);
    }
}
