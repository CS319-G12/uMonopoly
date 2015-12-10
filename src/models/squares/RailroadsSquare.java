package models.squares;

import models.cards.PropertyCard;
import models.cards.RailroadsCard;

/**
 * @author Alper Önder
 */
public class RailroadsSquare extends Square implements PropertySquare {

    // ATTRIBUTES
    private final RailroadsCard theRailroadsCard;

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

    @Override
    public PropertyCard getPropertyCard() {
        return theRailroadsCard;
    }
}
