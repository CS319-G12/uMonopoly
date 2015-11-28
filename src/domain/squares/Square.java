package domain.squares;

/**
 * Created by Alper Önder
 */
public class Square {

    // ATTRIBUTES
    protected int        id;
    protected int        position;
    protected String     name;
    protected SquareType type;

    // CONSTRUCTOR
    public Square(int id, int position, String name, SquareType type){
        this.id       = id;
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
