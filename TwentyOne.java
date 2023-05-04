import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwentyOne {
    private List<Card> cards = new ArrayList<>();

    public TwentyOne (List<Card> cards){this.cards = cards;}

    public void checkTwentyOne(int currentScore,int counter) {
        if (currentScore == 21) {
            System.out.println("\nYou win!\nYour score is: "+currentScore+"\nPress 'enter' to end the game.");
        } else if (currentScore == 22 && counter == 2) {
            System.out.println("\nYou win!\nPersian eye, your score is: "+currentScore+"\nPress 'enter' to end the game.");
        }else if(currentScore<21){
            System.out.println("Your score is: \n"+currentScore);
        }else{
            System.out.println("You lose.\nYour score is: "+currentScore+"\nPress 'enter' to end the game.");
        }
    }

    public void drawOrStop(){
        System.out.println("""
                Game menu:\s
                1. Game rules
                2. Play
                3. Quit\s
                To select one of the three options enter the corresponding number.""");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();
        do{
            if (decision.equals("1")){
                System.out.println("""
                                       \nThe game involves drawing consecutive cards until the total value of the cards\040
                                       is as close to (but not over) 21 as possible. The player receives cards from\040
                                       the deck until they decide that they do not want any more cards or\040
                                       they receive a score of 21 or more. A total of 22 or higher results in a loss.\040
                                       However, there is an exception to this rule: a pair of Aces, known as "Persian eye,"\040
                                       always results in a win, despite being worth 22 points. 
                                       \nPoint system:
                                       Cards 2 to 10 have a point value equal to their face value
                                       Jack - 2 pts.
                                       Queen - 3 pts.
                                       King - 4 pts.
                                       Ace - 11 pts.""");
            }else if (decision.equals("2")){
                System.out.println();
                Deck deck = new Deck(cards);
                deck.shuffle();
                int currentScore = 0;
                int counter = 0;
                do {
                    Card playersCard = deck.draw();
                    counter++;
                    if (playersCard.toString_number().equals("A")) {
                        currentScore += 11;
                    } else if (playersCard.toString_number().equals("K")) {
                        currentScore += 4;
                    } else if (playersCard.toString_number().equals("Q")) {
                        currentScore += 3;
                    } else if (playersCard.toString_number().equals("J")) {
                        currentScore += 2;
                    } else{
                        currentScore +=Integer.parseInt(playersCard.toString_number());
                    }
                    checkTwentyOne(currentScore,counter);
                    if (currentScore < 21){
                        System.out.println("Press 'enter' to draw a card or type 'q' to end the game.");
                    }
                    decision = scanner.nextLine();
                }
                while (!decision.equals("q") && currentScore < 21 );

            }
            System.out.println("\nTo quit the game press '3'.");
            decision = scanner.nextLine();
        }while(!decision.equals("3"));

    }

}
