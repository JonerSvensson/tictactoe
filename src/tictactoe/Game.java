package tictactoe;

import java.util.List;
import java.util.Scanner;

public class Game {
    // Global storage
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    Scanner scanner = new Scanner(System.in);

    // Game and settings
    public Game(){

        // Ask player 1 for name
        System.out.print("Enter Player 1's name: ");
        String player1Name = scanner.nextLine();
        char player1Marker = 'X';

        // Assign player1 with class
        this.player1 = new Player(player1Name, player1Marker, false);

        // Ask to play vs AI
        System.out.print("Play vs bot or real player? (bot/player): ");
        String isBot = scanner.nextLine();

        char player2Marker = 'O';

        // Sets player2 to bot if isBot == bot
        if (isBot.equalsIgnoreCase("bot")) {

            this.player2 = new Player("bot", player2Marker, true);

        // Asks player to for name if isBot != bot
        } else {
                System.out.print("Enter Player 2's name: ");
                String player2Name = scanner.nextLine();

                this.player2 = new Player(player2Name, player2Marker, false);
        }

        // Always makes player1 to go first
        this.currentPlayer = this.player1;
        // Star game Process
        start();
    }

    // Game process
    public void start(){
        //Creates game board
        board = new Board();

        // Runs over and over because always true
        while (true) {
            // Checks if currentPlayer is a bot
            if (currentPlayer.getBot()) {
                // Get all empty cells
                List<Cell> emptyCells = board.getEmptyCells();

                if (!emptyCells.isEmpty()) {
                    // Pick a random cell from the list
                    Cell move = emptyCells.get((int)(Math.random() * emptyCells.size()));

                    // Place the bot marker in the random cell
                    board.placeMarker(move.col, move.row, currentPlayer.getMarker());
                }

            } else{

                this.board.printBoard();
                
                int col, row;
                
                System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getMarker() + ")");
                System.out.print("Enter column and row (e.g. 1B): ");

                
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

                board.placeMarker(col, row, currentPlayer.getMarker());

                

            }
            if (board.checkWin(currentPlayer.getMarker())) {
                currentPlayer.addPoint();
                board.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            } else if (board.isBoardFull()) {
                board.printBoard();
                System.out.println("Draw!");
                break;
            }
            switchPlayer();
        }
        System.out.print("Score: " + player1.getName() + " " + player1.getScore() + " : " + player2.getScore() + " " + player2.getName());
        scanner.nextLine();
        System.out.print("Play again? (yes/no): ");
        String playAgain = scanner.nextLine();

        if (playAgain.equalsIgnoreCase("yes")) {
            board.reset();
            start();
        } else {
            System.out.println("Thx for playing!");
        }
    }
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}