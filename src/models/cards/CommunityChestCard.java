package models.cards;

import gui.CommunityChestCardView;

/**
 * @author buseburcu
 */
public class CommunityChestCard extends BonusCard {

    // ATTRIBUTES
    private int getEach;

    private CommunityChestCardView view;

    // CONSTRUCTOR
    public CommunityChestCard(int amount, boolean jail, boolean outOfJail, String desc, int getEach) {
        super(amount, jail, outOfJail, desc);
        this.getEach = getEach;

        this.view = new CommunityChestCardView(this);
    }

    // METHODS
    public int getPayAmountForEachPlayer() {
        return getEach;
    }

    public CommunityChestCardView getView() {
        return view;
    }

}
