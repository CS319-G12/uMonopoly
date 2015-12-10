package models.squares;

import models.cards.UtilityCard;

/**
 * @author Alper Önder
 */
public class UtilitySquare extends Square implements PropertySquare {

    // ATTRIBUTES
    private final UtilityCard theUtilityCard;

    // CONSTRUCTOR
    public UtilitySquare(int position, SquareType type, UtilityCard theUtilityCard){
        super(position, theUtilityCard.getName(), type);
        this.theUtilityCard = theUtilityCard;
    }

    // METHODS
    @Override
    public int getRentPrice(int numberOfBuildings){
        return theUtilityCard.getRentPrice(numberOfBuildings);
    }

    @Override
    public UtilityCard getCard() {
        return theUtilityCard;
    }
}
