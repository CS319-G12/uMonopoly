package domain.squares;

/**
 * @author Alper Önder
 */
public abstract class PropertySquare extends Square {

    // ATTRIBUTES

    // CONSTRUCTOR
    PropertySquare(int position, String name, SquareType type){
        super(position, name, type);
    }

    // METHODS
    public abstract int getRentPrice(int numberOfBuildings);

}
