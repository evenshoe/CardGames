public class Card {
    private final String number;
    private final String symbol;

    public Card(String number, String symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public String toString_number() {
        return (this.number);
    }

    public String toString_symbol() {
        return (" " + this.symbol + "\n");
    }

}