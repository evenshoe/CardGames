import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class War {
    private List<Card> cards = new ArrayList<>();
    private final List<Card> computersDeck = new ArrayList<>();

    private final List<Card> playersDeck = new ArrayList<>();

    private Card playersCard;
    private Card computersCard;


    public War(List<Card> cards) {
        this.cards = cards;
    }

    public int cardsValue(Card cardToCompare) {

        int value;
        if (cardToCompare.toString_number().equals("A")) {
            value = 14;
        } else if (cardToCompare.toString_number().equals("K")) {
            value = 13;
        } else if (cardToCompare.toString_number().equals("Q")) {
            value = 12;
        } else if (cardToCompare.toString_number().equals("J")) {
            value = 11;
        } else {
            value = Integer.parseInt(cardToCompare.toString_number());
        }
        return value;
    }

    public void cardsComparison() {

        if (cardsValue(playersCard) > cardsValue(computersCard)) {
            computersDeck.remove(0);
            playersDeck.remove(0);
            playersDeck.add(playersCard);
            playersDeck.add(computersCard);

        } else if (cardsValue(playersCard) < cardsValue(computersCard)) {
            computersDeck.remove(0);
            playersDeck.remove(0);
            computersDeck.add(playersCard);
            computersDeck.add(computersCard);

        }

    }

    public void gameplay() {
        System.out.println("""
                Game menu:\s
                1. Game rules
                2. Play
                3. Quit\s
                To select one of the three options enter the corresponding number.""");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();

        do {
            if (decision.equals("1")) {
                System.out.println("""
                        \nEach player receives half of the cards from the deck. Players simultaneously reveal one card from the top of\s
                        their deck and compare their values. The player with the higher card takes the cards and places them\s\040
                        at the bottom of their deck. War occurs when the cards shown by the players are identical.\s
                        \nThe war procedure is as follows: one card is revealed, placed face-down on the previous cards, then another card\s\040
                        is drawn, placed face-up on the previous card, and then the cards are compared. The higher value card wins and\s\040
                        the winner of the war takes all the cards used in the war.
                        The process is repeated if a winner cannot be determined during the war.\s\040
                        \nThe game is won by the player who takes all of the opponent's cards first.
                        \nThe hierarchy of card values is as follows (from highest to lowest):\s
                        Ace
                        King
                        Queen
                        Jack
                        10
                        9
                        8
                        7
                        6
                        5
                        4
                        3
                        2""");
            } else if (decision.equals("2")) {
                System.out.println();
                Collections.shuffle(cards);
                for (int i = 0; i < cards.size()/2 ; i++) {
                    playersDeck.add(cards.get(i));
                    computersDeck.add(cards.get(i+(cards.size()/2)));
                }

                do {
                    playersCard = playersDeck.get(0);
                    System.out.println("Player's card: "+playersCard.toString_number());
                    computersCard = computersDeck.get(0);
                    System.out.println("Computer's card: "+computersCard.toString_number());
                    if (cardsValue(playersCard) == cardsValue(computersCard)) {
                        if (playersDeck.size() <= 2){
                            System.out.println("The war begins, but player doesn't have enough cards. Computer wins the game.");
                            break;
                        }else if(computersDeck.size() <= 2){
                            System.out.println("The war begins, but computer doesn't have enough cards. YOU WIN THE GAME!");
                            break;
                        }
                        System.out.println("The war begins.");
                        int counter = 0;
                        do {
                            counter+=2;
                            playersCard = playersDeck.get(counter);
                            System.out.println("The deciding card of a player in the war: "+playersCard.toString_number());
                            computersCard = computersDeck.get(counter);
                            System.out.println("The deciding card of a computer in the war: "+computersCard.toString_number());

                        } while (cardsValue(playersCard) == cardsValue(computersCard));

                        if (cardsValue(playersCard) > cardsValue(computersCard)) {
                            for (int i = 0;i<=counter; i++) {
                                playersDeck.add(playersDeck.remove(0));
                                playersDeck.add(computersDeck.remove(0));
                            }

                        } else if (cardsValue(playersCard) < cardsValue(computersCard)) {
                            for (int i = 0;i<=counter; i++) {
                                computersDeck.add(playersDeck.remove(0));
                                computersDeck.add(computersDeck.remove(0));
                            }
                        }

                    } else {
                        cardsComparison();

                    }
                    System.out.println("Number of player's cards: " +playersDeck.size() + "\nNumber of computer's cards: "+computersDeck.size());
                    System.out.println("Press 'q' to end the game or any other key to continue.");
                    decision = scanner.nextLine();
                } while (!decision.equals("q") && playersDeck.size() > 0 && computersDeck.size() > 0);
                System.out.println("Number of player's cards: " +playersDeck.size() + "\nNumber of computer's cards: "+computersDeck.size());
                if (playersDeck.size() == 0){
                    System.out.println("\nThe computer won :(\n");
                }else if (computersDeck.size() == 0){
                    System.out.println("\nYOU WIN!\n");
                }
            }
            playersDeck.clear();
            computersDeck.clear();
            System.out.println("\nTo quit the game press '3'.");
            decision = scanner.nextLine();
        }while (!decision.equals("3")) ;
    }
}