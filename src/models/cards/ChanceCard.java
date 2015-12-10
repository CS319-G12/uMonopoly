package models.cards;

import gui.ChanceCardView;

/**
 * @author buseburcu
 */
public class ChanceCard extends BonusCard {

    // ATTRIBUTES
    private Integer goTo;
    private int payPerHouse;
    private int payPerHotel;

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

    public int getPayperHouseAmount() {
        return payPerHouse;
    }

    public int getPayPerHotelAmount() {
        return payPerHotel;
    }

    public ChanceCardView getView() {
        return view;
    }
}
