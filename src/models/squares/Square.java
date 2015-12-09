package models.squares;

/**
 * @author Alper Önder
 */
public class Square {

    // ATTRIBUTES
    private static int   idCounter = 0;
    protected final int id;
    protected final int position;
    protected final String name;
    protected final SquareType type;

    // CONSTRUCTOR
    public Square(int position, String name, SquareType type){
        this.id       = idCounter++;
        this.position = position;
        this.name     = name;
        this.type     = type;
    }

    // METHODS
    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public SquareType getSquareType(){
        return type;
    }

    public int getPosition(){
        return position;
    }
}
