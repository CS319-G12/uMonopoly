package domain.squares;

import domain.cards.BonusCard;
import domain.cards.CommunityChestCard;
import java.util.ArrayList;

/**
 * Created by Alper Önder
 */
public class CommunityChestCardSquare extends Square implements CardSquare {

    // ATTRIBUTES
    private ArrayList<CommunityChestCard> theCommunityChestCard;

    // CONSTRUCTOR
    public CommunityChestCardSquare(ArrayList<CommunityChestCard> theCommunityChestCard){
        this.theCommunityChestCard = (ArrayList<CommunityChestCard>) theCommunityChestCard.clone();
    }

    // METHODS
    public BonusCard pickCard(){
        return theCommunityChestCard.get((int)(Math.random() * theCommunityChestCard.size()));
    }
}
