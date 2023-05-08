package first_try;//-----------------------------------
//Naika Jean-Baptiste 40227367
//COMP249
//Assignment #1 Part I
//DUe date     Friday, February 3, 2023
import java.util.Scanner;
import java.util.Random;
public class LadderAndSnake {

    private int numOfPlayers;
    private Players players[];
    private String playerName;
    private String firstPlayer;

    private Positions Board[][] = new Positions[10][10];
    private int attempts = 1;

    /**
     * Creates first_try.LadderAndSnake, initializes number of players and names
     *
     * @param numOfPlayers
     */
    public LadderAndSnake(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        players = new Players[numOfPlayers];

        Scanner in = new Scanner(System.in);

        //initialize array of players
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + " name : ");
            playerName = in.next();
            players[i] = new Players(playerName);
        }

        int k = 0;
        //initializes board
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i % 2 == 0) {
                    k = 101 - (i * 10 + j + 1);
                } else {
                    k = 101 - (i * 10 + j + 1);
                }
                switch (k) {
                    case 1:
                        Board[i][j] = new Ladder(1, 38);
                        break;
                    case 4:
                        Board[i][j] = new Ladder(4, 14);
                        break;
                    case 9:
                        Board[i][j] = new Ladder(9, 31);
                        break;
                    case 16:
                        Board[i][j] = new Snake(16, 6);
                    case 21:
                        Board[i][j] = new Ladder(21, 42);
                        break;
                    case 28:
                        Board[i][j] = new Ladder(28, 84);
                        break;
                    case 36:
                        Board[i][j] = new Ladder(36, 44);
                        break;
                    case 48:
                        Board[i][j] = new Snake(48, 30);
                        break;
                    case 51:
                        Board[i][j] = new Ladder(51, 67);
                        break;
                    case 64:
                        Board[i][j] = new Snake(64, 60);
                        break;
                    case 71:
                        Board[i][j] = new Ladder(71, 91);
                        break;
                    case 79:
                        Board[i][j] = new Snake(79, 19);
                        break;
                    case 80:
                        Board[i][j] = new Ladder(80, 100);
                    case 93:
                        Board[i][j] = new Snake(93, 68);
                        break;
                    case 95:
                        Board[i][j] = new Snake(95, 24);
                        break;
                    case 97:
                        Board[i][j] = new Snake(97, 76);
                        break;
                    case 98:
                        Board[i][j] = new Snake(98, 78);
                        break;
                    default:
                        Board[i][j] = new Positions(k);
                        break;
                }
            }
        }
        //prints out board
        printBoard();
        System.out.println("Now deciding which player will start playing;");
        pickFirstPlayer();
        play();


    }

    /**
     * will use flipDice() method twice
     * the biggest value between the two gets first turn
     * if there's a tie, method called recursively
     */
    private void pickFirstPlayer() {

        int num1, num2;

        //flips dice and prints value after
        num1 = flipDice();
        System.out.println(players[0].getName() + " got a dice value of " + num1);
        num2 = flipDice();
        System.out.println(players[1].getName() + " got a dice value of " + num2);

        //if tie occurs recall the method which will happen recursively until tie is broken
        if (num1 == num2) {
            System.out.println("A tie was achieved between " + players[0].getName() + " and " + players[1].getName() + ". Attempting to break tie.");
            pickFirstPlayer();
            //records the attempts that is an attribute of the class so that we get the total number of attempts printed
            attempts++;

        } else if (num1 > num2) {
            //the name of the first player is stored from the array into the firstPlayer variable
            firstPlayer = players[0].getName().toString();
            System.out.println("Reached final decision on order of playing: " + firstPlayer + " then " + players[1].getName() + ". It took " + attempts + " attempt(s) before a final decision could be made.");
        } else {
            //the name of the second player is stored from the array into the firstPlayer variable
            firstPlayer = players[1].getName().toString();
            System.out.println("Reached final decision on order of playing: " + firstPlayer + " then " + players[0].getName() + ". It took " + attempts + " attempt(s) before a final decision could be made.");
        }
    }

    /**
     * object of random class to "roll dice" between 1 and 6
     *
     * @return random int between 1-6 inclusively
     */
    public int flipDice() {
        Random rnd = new Random();
        int diceRoll = rnd.nextInt(1, 7);

        return diceRoll;
    }

    /**
     * do-while loop to start the game
     * if-statement depending on who firstPlayer variable is
     */
    public void play() {


       /* int squareP1 = 0, squareP2 = 0;
        int diceRoll = 0;
        int n = 0;
        do {
            if (firstPlayer.equalsIgnoreCase(players[0].getName())) {
                diceRoll = flipDice();
                squareP1 += diceRoll;
                //TODO check these statements bcz it outputs "now at 0" every time
                players[0].setPosition(players[0].getPosition() + diceRoll);
                System.out.println(players[0].getName() + " got a dice value of " + diceRoll + "; now at " + players[0].getPosition());

                diceRoll = flipDice();
                players[1].setPosition(players[1].getPosition() + diceRoll);
                System.out.println(players[1].getName() + " got a dice value of " + diceRoll + "; now at " + players[1].getPosition());
                System.out.println(checkWinner(players[0].getPosition(), players[1].getPosition()));
            } else {
                diceRoll = flipDice();
                players[1].setPosition(players[1].getPosition() + diceRoll);
                System.out.println(players[1].getName() + " got a dice value of " + diceRoll + "; now at " + players[0].getPosition());

                diceRoll = flipDice();
                players[1].setPosition(players[0].getPosition() + diceRoll);
                System.out.println(players[0].getName() + " got a dice value of " + diceRoll + "; now at " + players[0].getPosition());
                System.out.println(checkWinner(players[0].getPosition(), players[1].getPosition()));
            }
            n++;
        }while(n < 4);
        while (players[0].getPosition() != 100 && players[1].getPosition() != 100);
    */
    }

    //TODO check which method should be used between checkWinner() and winnerExists()

    /**
     * checks if one of players has reached the square 100
     *
     * @param s1 score of first player
     * @param s2 score of second player
     * @return either the winning player or statement that game isn't done yet
     */
    private String checkWinner(int s1, int s2) {
        if (s1 == 100) {
            return players[0].getName() + " WINS";
        } else if (s2 == 100) {
            return players[1].getName() + "WINS";
        }
        return "Game not over; flipping again\n";
    }

    /**
     * winner is found if a player's position is 100
     *
     * @return true if a winner is found
     */
    private boolean winnerExists() {
        for (int i = 0; i < numOfPlayers; i++) {
            if (players[i].getPosition() == 100) {
                return true;
            }
        }
        return false;
    }

    /**
     * prints out the board
     * even numbered rows from right to left
     * odd numbered rows from left to right
     * TODO fix number printing and add the player's characters
     */
    private void printBoard() {

        //counter for number on "squares"
        int k = 100;


        for(int i = 10; i > 0; i--) {
            System.out.println("");

            // will always start by going into the else statement bcz starts with even number
            for (int j = 10; j > 0; j--) {
                //odd-numbered rows  work by increasing the value of k
                if (i % 2 != 0)
                {
                    System.out.printf("%3s", k);
                    k++;
                    if (j == 1) {
                        k -= 11;
                    }
                } else {
                    //FOR EVEN NUMBERED ROWS NUMBERS GROW FROM RIGHT TO LEFT
                    System.out.printf("%3s", k);
                    k--;

                    //if end of row is reached remove 9 for the following because the odd rows work by increasing k
                    if (j == 1) {
                        k -= 9;
                    }
                }
            }
        }

        System.out.println("");
    }

}
