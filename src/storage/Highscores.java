package storage;

/**
 * @author Alper Önder
 */
public class HighScores {

    // ATTRIBUTES
    private int    id;
    private String name;
    private String tokenFigure;
    private int    amount;
    private String date;

    // CONSTRUCTOR
    public HighScores(int id, String name, String tokenFigure, int amount, String date){
        this.id          = id;
        this.name        = name;
        this.tokenFigure = tokenFigure;
        this.amount      = amount;
        this.date        = date;
    }

    // METHODS
    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getTokenFigure(){
        return tokenFigure;
    }

    public int getAmount(){
        return amount;
    }

    public String getDate(){
        return date;
    }
}
