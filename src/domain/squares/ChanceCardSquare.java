package domain.squares;

import domain.cards.BonusCard;
import domain.cards.ChanceCard;

import java.util.List;

/**
 * @author Alper Önder
 */
public class ChanceCardSquare extends Square implements CardSquare {

    // ATTRIBUTES
    private final List<ChanceCard> theChanceCardList;
    private final int maxSelectableCardSize;
    private int selectedCardID;
    private int selectableCardSize;


    // CONSTRUCTOR
    public ChanceCardSquare( int position, String name, SquareType type, List<ChanceCard> theChanceCardList){
        super(position, name, type);
        this.theChanceCardList = theChanceCardList;
        maxSelectableCardSize  = theChanceCardList.size();
        selectableCardSize     = maxSelectableCardSize;
    }

    // METHODS
    public BonusCard pickCard(){ // Getting randon Chance Car
        if(selectableCardSize == 0)
            selectableCardSize = maxSelectableCardSize;
        selectedCardID = (int)(Math.random() * selectableCardSize);
        theChanceCardList.add(theChanceCardList.get(selectedCardID));
        theChanceCardList.remove(theChanceCardList.get(selectedCardID));
        selectableCardSize--;
        return theChanceCardList.get(theChanceCardList.size()-1);
    }
}
