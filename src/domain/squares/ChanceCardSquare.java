package domain.squares;

import domain.cards.BonusCard;
import domain.cards.ChanceCard;
import java.util.ArrayList;

/**
 * Created by Alper Önder
 */
public class ChanceCardSquare extends Square implements CardSquare {

    // ATTRIBUTES
    private ArrayList<ChanceCard> theChanceCardList;

    // CONSTRUCTOR
    public ChanceCardSquare(int id, int position, String name, SquareType type, ArrayList<ChanceCard> theChanceCardList){
        super(id, position, name, type);
        this.theChanceCardList = (ArrayList<ChanceCard>) theChanceCardList.clone();
    }

    // METHODS
    public BonusCard pickCard(){ // Getting randon Chance Card
        return theChanceCardList.get((int)(Math.random() * theChanceCardList.size()));
    }
}
