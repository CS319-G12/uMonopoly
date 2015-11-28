package domain.squares;

import domain.cards.UtilityCard;

/**
 * Created by Alper Önder
 */
public class UtilitySquare extends PropertySquare {

    // ATTRIBUTES
    private UtilityCard theUtilityCard;

    // CONSTRUCTOR
    public UtilitySquare(int id, int position, String name, SquareType type, UtilityCard theUtilityCard){
        super(id, position, name, type);
        this.theUtilityCard = theUtilityCard;
    }

    // METHODS
    public int getRentPrice(){
        // TODO
        return 0;
    }

}
