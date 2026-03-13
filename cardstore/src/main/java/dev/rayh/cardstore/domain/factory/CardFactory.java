package dev.rayh.cardstore.domain.factory;

import dev.rayh.cardstore.domain.card.entity.CardEntity;
import dev.rayh.cardstore.domain.card.model.Card;
import org.springframework.beans.BeanUtils;

public class CardFactory {

    public static Card fromEntity(CardEntity entity){
        Card c = new Card();

        BeanUtils.copyProperties(entity, c);
        
        


        return c;
    }

    public static CardEntity fromModel(Card model){
        CardEntity entity = new CardEntity();

        BeanUtils.copyProperties(model, entity);

        return entity;
    }
}
