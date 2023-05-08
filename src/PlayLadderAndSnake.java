package first_try; /**
 * @author Naika Jean-Baptiste
 */

//-----------------------------------
//Naika Jean-Baptiste 40227367
//COMP249
//Assignment #1 Part II
//DUe date     Friday, February 3, 2023
import java.util.Scanner;

public class PlayLadderAndSnake {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int players;

        System.out.println("Welcome to a Snakes and first_try.Ladder game!\nEnter a number of players for your game: ");
        players = in.nextInt();
        if ( players > 2){
            System.out.println("Initialization was attempted for " +players+ " players; however, this is only expected for an extended version the game. Value will be set to 2\n");
            players = 2;
        } else if (players < 2) {
            System.out.print("Error: Cannot execute the game with less than 2 players! Will exit");
            System.exit(0);
        }

        LadderAndSnake game = new LadderAndSnake(players);
        in.close();
    }
}