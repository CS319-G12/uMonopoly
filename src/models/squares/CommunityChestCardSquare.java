package models.squares;

import models.cards.BonusCard;
import models.cards.CommunityChestCard;

import java.util.List;

/**
 * @author Alper Önder
 */
public class CommunityChestCardSquare extends CardSquare {

    // ATTRIBUTES
    private final List<CommunityChestCard> theCommunityChestCard;
    private final int maxSelectableCardSize;
    private int selectableCardSize;

    private CommunityChestCard chosenCard;

    // CONSTRUCTOR
    public CommunityChestCardSquare(int position, List<CommunityChestCard> theCommunityChestCard) {
        super(position, "Communty Chest", SquareType.COMMUNITY_CHEST);
        this.theCommunityChestCard = theCommunityChestCard;
        maxSelectableCardSize = theCommunityChestCard.size();
        selectableCardSize = maxSelectableCardSize;

        chosenCard = null;
    }

    // METHODS
    public BonusCard pickCard() {
        if (selectableCardSize == 0)
            selectableCardSize = maxSelectableCardSize;
        int selectedCardID = (int) (Math.random() * selectableCardSize);
        theCommunityChestCard.add(theCommunityChestCard.get(selectedCardID));
        theCommunityChestCard.remove(theCommunityChestCard.get(selectedCardID));
        selectableCardSize--;
        chosenCard = theCommunityChestCard.get(theCommunityChestCard.size() - 1);
        return chosenCard;
    }

    @Override
    public CommunityChestCard getCard() {
        return chosenCard;
    }
}
