package models.cards;

import gui.CommunityChestCardView;

import javax.swing.*;

/**
 * @author buseburcu
 */
public class CommunityChestCard extends BonusCard {

    // ATTRIBUTES
    private final int getEach;

    private final CommunityChestCardView view;

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

    @Override
    public JPanel getView() {
        return view.getContent();
    }

}
