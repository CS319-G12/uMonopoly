package domain.squares;

import domain.cards.RailroadsCard;

/**
 * Created by Alper Önder
 */
public class RailroadsSquare extends PropertySquare {

    // ATTRIBUTES
    private RailroadsCard theRailroadsCard;

    // CONSTRUCTOR
    public RailroadsSquare(int id, int position, String name, SquareType type, RailroadsCard theRailroadsCard){
        super(id, position, name, type);
        this.theRailroadsCard = theRailroadsCard;
    }

    // METHODS
    public int getRentPrice(){
        // TODO
        return 0;
    }
}
