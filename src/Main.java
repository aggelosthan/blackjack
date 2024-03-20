import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startGame();
    }












    // Function that generates a random number between 1-13 (Cards)
    public static int drawRandomCard() {
        return (int) (Math.random() * 13) + 1;
    }


    // Function that returns a card  from 1 to 13.
    public static String card(int cardNumber) {
        switch (cardNumber) {
            case 1:
                return
                        "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";
            case 2:
                return
                        "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";
            case 3:
                return
                        "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";
            case 4:
                return
                        "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";
            case 5:
                return
                        "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";
            case 6:
                return
                        "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";
            case 7:
                return
                        "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";
            case 8:
                return
                        "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";
            case 9:
                return
                        "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";

            case 10:
                return
                        "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";
            case 11:
                return
                        "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";
            case 12:
                return
                        "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";
            case 13:
                return
                        "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";

            default:
                return "card not found";
        }
    }


    // Function that start the game.
    public static void userConfirms() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to BlackJAVckA");
        System.out.print("Press anything to begin...");
        scan.nextLine();

    }


    // A function that gives the player a card.
    public static int userCard() {
        int card = drawRandomCard();
        System.out.println("You get a \n" + card(card));
        if (card > 9) {
            card = 10;
        }

        return card;
    }


    // A function that gives player both cards and the sum.
    public static int userCards(){
        int cardOne = userCard();
        int cardTwo = userCard();

        if (cardOne > 9){
            cardOne = 10;
        }
        if (cardTwo > 9){
            cardTwo = 10;
        }
        int sum = cardOne + cardTwo;
        System.out.println("Your card sum is " + sum + "\n");
        return sum;
    }


    // A function that gives dealer a card.
    public static int dealerCard() {
        int card = drawRandomCard();
        System.out.println("The dealer shows\n" + card(card));
        if (card > 9) {
            card = 10;
        }

        return card;
    }


    // A function that gives the dealer cards.
    public static int dealerCards() {
        int dealerCard = drawRandomCard();
        int sum = 0;
        System.out.println("The dealer shows\n" + card(dealerCard));
        System.out.println(backSideCard());
        if (dealerCard >= 10) {
            dealerCard = 10;
        }
        System.out.println("Dealer card sum is " + dealerCard);
        return sum;
    }


    // A function that prints the back side of the card (used in dealers cards function).
    public static String backSideCard() {
        return
                "   _____\n" +
                        "  |     |\n" +
                        "  |  J  |\n" +
                        "  | JJJ |\n" +
                        "  |  J  |\n" +
                        "  |_____|\n";
    }


    // A function that returns if the user wants to hit or stand.
    public static String hitOrStand() {
        Scanner scan = new Scanner(System.in);
        System.out.print("hit or stand? ");
        String userInput = scan.nextLine();
        while (!userInput.equals("hit") && !userInput.equals("stand")) {
            System.out.println("Please write 'hit' or 'stand'");
            userInput = scan.nextLine();
        }
        return userInput;
    }


    // Game logic function.
    public static void startGame() {
        userConfirms();
        dashes();
        System.out.println("\nBlackjack Checker for the player.!\n");
        blackJack(userCard(),userCard(), "Player");             // Checks if it is a blackjack for the player.
        System.out.println("\nBlackjack checker for the dealer.!\n");
        blackJack(dealerCard(),dealerCard(), "Dealer");         // Checks if it is a blackjack for the dealer.
        dashes();

        int userSum = userCards();
        int dealerSum = dealerCards();
        String hitOrStand = hitOrStand();

        boolean gameEnds = false;
        while (!gameEnds) {

            if (hitOrStand.equals("hit")) {
                userSum += userCard();
                System.out.println("Your total: " + userSum);
                if (userSum > 21) {
                    System.out.println("Bust. You lost.");
                    gameEnds = true;
                } else {
                    hitOrStand = hitOrStand();
                }
            } else if (hitOrStand.equals("stand")) {
                while (dealerSum < 17) { // Dealer must hit if hand total is less than 17
                    dealerSum += dealerCard();
                }
                System.out.println("Dealer's total: " + dealerSum);
                if (dealerSum > 21) {
                    System.out.println("Dealer busts. You win.");
                    gameEnds = true;
                } else {
                    if (userSum > dealerSum) {
                        System.out.println("You win.");
                    } else if (userSum < dealerSum) {
                        System.out.println("Dealer wins.");
                    } else {
                        System.out.println("It's a tie.");
                    }
                    gameEnds = true;
                }
            } else {
                System.out.println("Invalid input. Please enter 'hit' or 'stand'.");
                hitOrStand = hitOrStand();
            }
        }
    }


    // A function that checks if there is a black jack.
    public static void blackJack(int cardOne, int cardTwo, String turn){
        if ((cardOne == 1 && cardTwo == 10) || (cardOne == 10 && cardTwo == 1)){
            if(turn.equals("Player")){
                System.out.println(card(userCard()));
                System.out.println(card(userCard()));
            }else{
                System.out.println(card(dealerCard()));
                System.out.println(card(dealerCard()));
            }
            System.out.println("It is a blackjack!!!\n");
            System.out.println("Player won.");
            System.exit(0);
        }
    }

    // LOL.
    public static void dashes(){
        System.out.println("\n------------------------\n----------------------\n-----------------");
    }
}