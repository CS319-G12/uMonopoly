package models.squares;

import models.cards.BonusCard;
import models.cards.ChanceCard;

import java.util.List;

/**
 * @author Alper Önder
 */
public class ChanceCardSquare extends CardSquare {

    // ATTRIBUTES
    private final List<ChanceCard> theChanceCardList;
    private final int maxSelectableCardSize;
    private int selectableCardSize;

    private ChanceCard chosenCard;


    // CONSTRUCTOR
    public ChanceCardSquare(int position, List<ChanceCard> theChanceCardList) {
        super(position, "Chance", SquareType.CHANCE);
        this.theChanceCardList = theChanceCardList;
        maxSelectableCardSize = theChanceCardList.size();
        selectableCardSize = maxSelectableCardSize;
        chosenCard = null;
    }

    // METHODS
    public BonusCard pickCard() { // Getting random Chance Card
        if (selectableCardSize == 0)
            selectableCardSize = maxSelectableCardSize;
        int selectedCardID = (int) (Math.random() * selectableCardSize);
        theChanceCardList.add(theChanceCardList.get(selectedCardID));
        theChanceCardList.remove(theChanceCardList.get(selectedCardID));
        selectableCardSize--;
        chosenCard = theChanceCardList.get(theChanceCardList.size() - 1);
        return chosenCard;
    }

    @Override
    public ChanceCard getCard() {
        return chosenCard;
    }
}
