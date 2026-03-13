package dev.rayh.cardstore.domain.deck;

import dev.rayh.cardstore.domain.card.model.Card;
import dev.rayh.cardstore.domain.card.types.SuperType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeckAndCard {

    private Deck deck;
    private Card card;
    private int count;

    // positive numbers to adds, negative to subtracts
    public void updateQuantity(int qtd) {
        if (this.card.getSupertype().equals(SuperType.ENERGY)){
            this.count = qtd;
        }

        if ((this.count < 4)){
            if ((this.count + qtd) > 4){
                this.count = 4;
            }else{
                this.count += qtd;
            }
        }
    }
}
