package dev.rayh.cardstore.domain.factory;

import dev.rayh.cardstore.domain.card.entity.CardEntity;
import dev.rayh.cardstore.domain.card.model.Card;
import dev.rayh.cardstore.domain.card.set.Set;
import dev.rayh.cardstore.domain.dto.CardDto;
import org.springframework.beans.BeanUtils;

public class CardFactory {

    public static Card modelFromEntity(CardEntity entity){
        Card c = new Card();

        BeanUtils.copyProperties(entity, c);
        
        c.setSet(SetFactory.modelFromEntity(entity.getSet()));


        return c;
    }

    public static CardEntity entityFromModel(Card model){
        CardEntity entity = new CardEntity();

        BeanUtils.copyProperties(model, entity);

        entity.setSet(SetFactory.entityFromModel(model.getSet()));

        return entity;
    }

    public static Card modelFromRecord(CardDto r) {
        Card c = new Card();
        Set set = new Set();
        BeanUtils.copyProperties(r, c);

        set.setId(r.set());
        c.setSet(set);

        return c;
    }
}
