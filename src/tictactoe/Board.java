package tictactoe;

public class Board {
    private char[][] cells;

    public Board(){
        cells = new char[3][3];
        reset();
    }

    // Loops through each cell and sets it to a blank space
    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    // Prints the board with markers included. Also added column and row number/letters
    public void printBoard() {
        System.out.println("    1   2   3  ");
        System.out.println("  -------------");
        for (int i = 0; i < 3; i++) {

            // Convert ABC (row indicators) to ascii to make it easier to loop through
            System.out.print((char)(65 + i)+" | ");

            // Prints either default marker ' ' or X/O in the correct cell
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + " | ");
            }
            System.out.println();
            System.out.println("  -------------");
        }
    }
    
    // Returns false if row and column is not == ' '
    public boolean isCellEmpty(int col, int row) { 
        return cells[row][col] == ' '; }

    // Places marker in the correct cell
    public void placeMarker(int col, int row, char marker) {
            cells[row][col] = marker;
    }
}