package models.squares;

import java.util.Observable;

/**
 * @author Alper Önder
 */
public class Square extends Observable{

    // ATTRIBUTES
    private static int id_counter = 0;
    private final int id;
    private final int position;
    private final String name;
    private final SquareType type;

    // CONSTRUCTOR
    public Square(int position, String name, SquareType type) {
        this.id = id_counter++;
        this.position = position;
        this.name = name;
        this.type = type;
    }

    // METHODS
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SquareType getSquareType() {
        return type;
    }

    public int getPosition() {
        return position;
    }
}
