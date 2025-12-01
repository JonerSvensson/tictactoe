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

    // Loops through all cells and return false if a cell == ' '
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

        // Checks every possible victory alignment and returns false if none is fulfilled
        public boolean checkWin(char marker) {
        // Rows --
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == marker && cells[i][1] == marker && cells[i][2] == marker) {
                return true;
            }
        }
        // Columns |
        for (int j = 0; j < 3; j++) {
            if (cells[0][j] == marker && cells[1][j] == marker && cells[2][j] == marker) {
                return true;
            }
        }
        // Diagonals \
        if (cells[0][0] == marker && cells[1][1] == marker && cells[2][2] == marker) {
            return true;
        }
        // Diagonals /
        if (cells[0][2] == marker && cells[1][1] == marker && cells[2][0] == marker) {
            return true;
        }
        return false;
    }
}