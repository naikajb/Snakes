/**
 * Driver for Snakes and Ladders game in terminal
 *
 * @author Naika Jean-Baptiste
 */

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