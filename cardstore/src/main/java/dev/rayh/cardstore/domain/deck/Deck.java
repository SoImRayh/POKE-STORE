package dev.rayh.cardstore.domain.deck;

import dev.rayh.cardstore.domain.card.model.Card;
import dev.rayh.cardstore.domain.card.types.Type;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Deck {
    private final int MAX_CARD_QUANTITY = 60;

    private String id;
    private String name;
    private List<Type> types;
    private List<DeckAndCard> cards = new ArrayList<>(MAX_CARD_QUANTITY);

    public Deck (){
        this.name = null;
    }

    public void updateCardQuantity(Card card, int qtd){
        int indexIfExists;

        indexIfExists = verifyIfExistsAndReturnTheIndex(card);
        if (indexIfExists > -1){
            this.cards.get(indexIfExists).updateQuantity(qtd);
            if (this.cards.get(indexIfExists).getCount() < 1){
                this.cards.remove(indexIfExists);
            }
        }
    }

    public void addCard(Iterable<Card> cards){
        for (DeckAndCard c : this.cards){
            addCard(c.getCard(), c.getCount());
        }
    }

    /// If the quantity overflow the max number of cards, cap to max (60 cards)
    public void addCard(Card card, int qtd){
        int indexIfExists;


        if (getQuantityOfCards() < MAX_CARD_QUANTITY){
            if ((getQuantityOfCards() + qtd) > MAX_CARD_QUANTITY)
                qtd -= (getQuantityOfCards()+ qtd) % MAX_CARD_QUANTITY;

            indexIfExists = verifyIfExistsAndReturnTheIndex(card);

            if (indexIfExists > -1){
                this.cards.get(indexIfExists).updateQuantity(qtd);
            }else{
                this.cards.add(new DeckAndCard(this,card, qtd));
            }
        }
    }

    /// returns index of exists or -1 if it does not
    private int verifyIfExistsAndReturnTheIndex(Card c){
        for (int i = 0; i < MAX_CARD_QUANTITY; i++) {
            if (this.cards.get(i) != null){
                if (this.cards.get(i).getCard().equals(cards))
                    return i;
            }
        }

        return -1;
    }

    private int getQuantityOfCards(){
        int quantity;

        quantity = 0;
        for (DeckAndCard dc : this.cards){
            quantity += dc.getCount();
        }
        return quantity;
    }

}
