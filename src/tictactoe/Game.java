package tictactoe;

import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    Scanner scanner = new Scanner(System.in);

    // Game and settings
    public Game(){

        System.out.print("Enter Player 1's name: ");
        String player1Name = scanner.nextLine();
        char player1Marker = 'X';

        this.player1 = new Player(player1Name, player1Marker, false);

        System.out.print("Play vs bot or real player? (bot/player): ");
        String playAgain = scanner.nextLine();

        char player2Marker = 'O';

        if (playAgain.equalsIgnoreCase("bot")) {

            this.player2 = new Player("bot", player2Marker, true);
        } else {
                System.out.print("Enter Player 2's name: ");
                String player2Name = scanner.nextLine();

                this.player2 = new Player(player2Name, player2Marker, false);
        }

        this.currentPlayer = this.player1;
        start();
    }

    // Game process
    public void start(){
        board = new Board();

        // Debug
        this.board.printBoard();
        System.out.println("is this a bot? " + this.player2.getBot());
        
    }
}