package domain.squares;

import domain.cards.RailroadsCard;

/**
 * @author Alper Önder
 */
public class RailroadsSquare extends PropertySquare {

    // ATTRIBUTES
    private RailroadsCard theRailroadsCard;

    // CONSTRUCTOR
    public RailroadsSquare(int position, String name, SquareType type, RailroadsCard theRailroadsCard){
        super(position, name, type);
        this.theRailroadsCard = theRailroadsCard;
    }

    // METHODS
    @Override
    public int getRentPrice(int numberOfBuildings){
        return theRailroadsCard.getRentPrice(numberOfBuildings);
    }
}
