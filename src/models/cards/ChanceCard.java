package models.cards;

import gui.ChanceCardView;

import javax.swing.*;

/**
 * @author buseburcu
 */
public class ChanceCard extends BonusCard {

    // ATTRIBUTES
    private final Integer goTo;
    private final int payPerHouse;
    private final int payPerHotel;

    private ChanceCardView view;

    // CONSTRUCTOR
    public ChanceCard(int amount, boolean jail, boolean outOfJail, String desc, Integer goTo, int payPerHouse, int payPerHotel) {
        super(amount, jail, outOfJail, desc);

        this.goTo = goTo;
        this.payPerHouse = payPerHouse;
        this.payPerHotel = payPerHotel;

        this.view = new ChanceCardView(this);
    }

    // METHODS
    public Integer getGoToDestination() {
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
