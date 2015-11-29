package domain.cards;

/**
 * @author buseburcu
 */
public class CommunityChestCard extends BonusCard {

    // ATTRIBUTES
    private int getEach;

    private CommunityChestCardView view; // TODO fix this

    // CONSTRUCTOR
    public CommunityChestCard(int amount, boolean jail, boolean outOfJail, String desc, int getEach) {
        super(amount, jail, outOfJail, desc);
        this.getEach = getEach;
    }

    // METHODS
    public int getPayAmountForEachPlayer() {
        return getEach;
    }

}
