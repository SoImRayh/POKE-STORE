package dev.rayh.cardstore.domain.factory;

import dev.rayh.cardstore.domain.card.set.Set;
import dev.rayh.cardstore.domain.card.set.SetEntity;
import org.springframework.beans.BeanUtils;

public class SetFactory {
    public static Set modelFromEntity(SetEntity set){
        Set model;

        if (set == null){
            return null;
        }

        model = new Set();
        BeanUtils.copyProperties(set, model);

        return model;
    }

    public static SetEntity entityFromModel(Set set){
        SetEntity entity;

        if (set == null)
            return null;

        entity = new SetEntity();

        BeanUtils.copyProperties(set, entity);
        if (set.getCards() != null){
            entity.setCards(
                    set.getCards().stream().map(CardFactory::entityFromModel).toList()
            );
        }

        return entity;
    }
}
