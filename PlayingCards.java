import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;


public class PlayingCards {

    public static void main(String[] args) {
        List<Card> cards = new ArrayList<Card>();
        String[] symbol = {"pik", "trefl","kier","karo"};
        String[] number = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for(int j = 0; j<4;j++) {
            for (int i = 0; i < 13; i++) {
                Card card = new Card(number[i], symbol[j]);
                cards.add(card);
            }
        }
        String gameMenu = """
                Game menu:\s
                1. TwentyOne
                2. War
                3. Quit
                To select one of the games enter the corresponding number.""";
        System.out.println(gameMenu);
        Scanner scanner =  new Scanner(System.in);
        String decision = scanner.nextLine();;

        do{
            if (decision.equals("1")){
                System.out.println();
                TwentyOne player1 = new TwentyOne(cards);
                player1.drawOrStop();
            } else if (decision.equals("2")) {
                System.out.println();
                War game = new War(cards);
                game.gameplay();
            }else{
                System.out.println("Enter the right number.\n");
            }
            System.out.println(gameMenu);
            decision = scanner.nextLine();
        }while(!decision.equals("3"));





    }
}
