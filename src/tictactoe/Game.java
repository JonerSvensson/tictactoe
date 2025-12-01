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

        while (true) {
            this.board.printBoard();
            
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getMarker() + ")");
            System.out.print("Enter column and row (e.g. 1B): ");

            int col, row;

            try{

                String input = scanner.next().toUpperCase();

                // Convert String input to ascii to get value between 0-2 (subtract ascii value)
                col = ((int) (input.charAt(0)) - 49);
                row = ((int) (input.charAt(1)) - 65);

                // Initiates catch if col/row is not 0-2 after conversion
                if (col < 0 || col > 2 || row < 0 || row > 2) {
                    throw new IllegalArgumentException();
                }
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1-3 for column and letter A, B or C for row.");
                scanner.nextLine();
                continue;
            }

            if (board.isCellEmpty(col, row)) {
                board.placeMarker(col, row, currentPlayer.getMarker());
            }

            // Debug
            System.out.println("is this a bot? " + this.player2.getBot());
            System.out.println("row: " + row +" "+ "col: " + col);

            switchPlayer();
        }
    }
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}