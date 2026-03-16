package dev.rayh.cardstore.domain.card.deck;

import dev.rayh.cardstore.domain.card.model.Card;
import dev.rayh.cardstore.domain.card.set.Set;
import dev.rayh.cardstore.domain.card.set.SetEntity;
import dev.rayh.cardstore.domain.factory.CardFactory;
import org.springframework.beans.BeanUtils;

public class DeckFactory {
    public static Deck modelFromEntity(DeckEntity entity){
        Deck model = new Deck();

        BeanUtils.copyProperties(entity, model);

        model.setCards(entity.getCards());


        return model;
    }

    public static DeckEntity entityFromModel(Deck deck){
        DeckEntity entity = new DeckEntity();

        BeanUtils.copyProperties(deck, entity);

        entity.setCards(deck.getCards());

        return entity;
    }

    public static Deck modelFromDeckCardDtoRecord(DeckDto dto){
        Deck deck = new Deck();

        deck.setId(dto.id());
        deck.setName(dto.name());
        deck.setTypes(dto.types());
        deck.setCards(null);

        return deck;
    }
}
