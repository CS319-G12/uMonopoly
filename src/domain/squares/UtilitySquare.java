package domain.squares;

import domain.cards.UtilityCard;

/**
 * @author Alper Önder
 */
public class UtilitySquare extends PropertySquare {

    // ATTRIBUTES
    private UtilityCard theUtilityCard;

    // CONSTRUCTOR
    public UtilitySquare(int position, String name, SquareType type, UtilityCard theUtilityCard){
        super(position, name, type);
        this.theUtilityCard = theUtilityCard;
    }

    // METHODS
    @Override
    public int getRentPrice(int numberOfBuildings){
        return theUtilityCard.getRentPrice(numberOfBuildings);
    }
}
