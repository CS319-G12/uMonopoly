package domain.squares;

import domain.cards.BonusCard;
import domain.cards.CommunityChestCard;

import java.util.List;

/**
 * @author Alper Önder
 */
public class CommunityChestCardSquare extends Square implements CardSquare {

    // ATTRIBUTES
    private final List<CommunityChestCard> theCommunityChestCard;
    private final int maxSelectableCardSize;
    private int selectedCardID;
    private int selectableCardSize;

    // CONSTRUCTOR
    public CommunityChestCardSquare(int position, String name, SquareType type, List<CommunityChestCard> theCommunityChestCard) {
        super(position, name, type);
        this.theCommunityChestCard = theCommunityChestCard;
        maxSelectableCardSize      = theCommunityChestCard.size();
        selectableCardSize         = maxSelectableCardSize;
    }

    // METHODS
    public BonusCard pickCard() {
        if (selectableCardSize == 0)
            selectableCardSize = maxSelectableCardSize;
        selectedCardID = (int) (Math.random() * selectableCardSize);
        theCommunityChestCard.add(theCommunityChestCard.get(selectedCardID));
        theCommunityChestCard.remove(theCommunityChestCard.get(selectedCardID));
        selectableCardSize--;
        return theCommunityChestCard.get(theCommunityChestCard.size() - 1);
    }
}
