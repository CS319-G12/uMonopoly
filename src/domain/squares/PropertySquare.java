package domain.squares;

/**
 * Created by
 */
public abstract class PropertySquare extends domain.squares.Square {

    // ATTRIBUTES

    // CONSTRUCTOR
    PropertySquare(int id, int position, String name, SquareType type){
        super(id, position, name, type);
    }

    // METHODS
    public abstract int getRentPrice();

}
