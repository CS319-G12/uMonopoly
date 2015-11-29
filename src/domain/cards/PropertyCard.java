package domain.cards;

import domain.Player;

/**
 * @author buseburcu
 */
public abstract class PropertyCard {

    // ATTRIBUTES
    private int sellPrice;
    private int mortgagePrice;
    private int[] rentPrices;

    private Player owner;

    // CONSTRUCTOR
    protected PropertyCard(int sellPrice, int mortgagePrice) {
        this.sellPrice = sellPrice;
        this.mortgagePrice = mortgagePrice;
    }

    // METHODS
    public int getSellPrice() {
        return sellPrice;
    }

    public int getMortgagePrice() {
        return mortgagePrice;
    }

    protected int[] getRentPrices() {
        return rentPrices.clone();
    }

    protected void setRentPrices(int... rents) {
        rentPrices = rents;
    }

    public abstract int getRentPrice(int number);

}
