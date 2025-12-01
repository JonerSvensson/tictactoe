package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private char[][] cells;

    public Board(){
        cells = new char[3][3];
        reset();
    }

    // Loops through each cell and sets it to a blank space
    public void reset() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cells[row][col] = ' ';
            }
        }
    }

    // Prints the board with markers included. Also added column and row number/letters
    public void printBoard() {
        System.out.println("    1   2   3  ");
        System.out.println("  -------------");
        for (int row = 0; row < 3; row++) {

            // Convert ABC (row indicators) to ascii to make it easier to loop through
            System.out.print((char)(65 + row)+" | ");

            // Prints either default marker ' ' or X/O in the correct cell
            for (int col = 0; col < 3; col++) {
                System.out.print(cells[row][col] + " | ");
            }
            System.out.println();
            System.out.println("  -------------");
        }
    }

    public List<Cell> getEmptyCells() {
        List<Cell> emptyCells = new ArrayList<>();

        // Loops through each cell to check if empty and adds them to a list
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (cells[row][col] == ' ') {
                    emptyCells.add(new Cell(row, col));
                }
            }
        }

        return emptyCells;
    }
    
    // Returns false if row and column is not == ' '
    public boolean isCellEmpty(int col, int row) { 
        return cells[row][col] == ' '; }

    // Places marker in the correct cell
    public void placeMarker(int col, int row, char marker) {
            cells[row][col] = marker;
    }
}