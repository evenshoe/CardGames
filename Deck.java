import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deck = new ArrayList<>();

    public Deck(List<Card> deck){this.deck = deck;}

    public void shuffle(){
        Collections.shuffle(this.deck);
    }
    public Card draw(){
        System.out.println("Card drawn form the top of the deck: ");
        Card numberOfDrawnCard = new Card(this.deck.get(deck.size()-1).toString_number(), this.deck.get(deck.size()-1).toString_symbol());
        System.out.print(numberOfDrawnCard.toString_number());
        System.out.print(numberOfDrawnCard.toString_symbol());
        deck.remove(this.deck.size()-1);
        return(numberOfDrawnCard);
    }
    public void toString_deck() {
        for (Card card : this.deck) {
            System.out.print(card.toString_number());
            System.out.print(card.toString_symbol());
        }
    }
}