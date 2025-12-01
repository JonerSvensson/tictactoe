package tictactoe;

public class Player {
    private String name;
    private char marker;
    private boolean bot;
    private int score;


    public Player(String name, char marker, boolean bot){
        this.name = name;
        this.marker = marker;
        this.bot = bot;
    }
    
    public String getName() {
        return name;
    }

    public char getMarker() {
        return marker;
    }

    public boolean getBot() {
        return bot;
    }
    
    public int getScore() {
        return score;
    }

    public void addPoint() {
        score++;
    }

    public void resetScore() {
        score = 0;
    }

}