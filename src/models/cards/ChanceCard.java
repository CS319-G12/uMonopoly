package models.cards;

import gui.ChanceCardView;

import javax.swing.*;

/**
 * @author buseburcu
 */
public class ChanceCard extends BonusCard {

    // ATTRIBUTES
    private final int goTo;
    private final boolean hasGoTo;
    private final int payPerHouse;
    private final int payPerHotel;

    private ChanceCardView view;

    // CONSTRUCTOR
    public ChanceCard(int amount, boolean jail, boolean outOfJail, String desc, boolean hasGoTo, int goTo, int payPerHouse, int payPerHotel) {
        super(amount, jail, outOfJail, desc);

        this.hasGoTo = hasGoTo;
        this.goTo = goTo;
        this.payPerHouse = payPerHouse;
        this.payPerHotel = payPerHotel;

        this.view = new ChanceCardView(this);
    }

    // METHODS
    public boolean hasGoTo() {
        return hasGoTo;
    }

    public int getGoToDestination() {
        return goTo;
    }

    public int getPayPerHouseAmount() {
        return payPerHouse;
    }

    public int getPayPerHotelAmount() {
        return payPerHotel;
    }

    @Override
    public JPanel getView() {
        return view.getContent();
    }
}
