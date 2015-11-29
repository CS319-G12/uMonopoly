package domain.squares;

/**
 * @author Alper Önder
 */
public class Square {

    // ATTRIBUTES
    private static int   idCounter = 0;
    protected int        id;
    protected int        position;
    protected String     name;
    protected SquareType type;

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
