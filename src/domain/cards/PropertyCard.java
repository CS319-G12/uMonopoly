package domain.cards;

import domain.Player;
import gui.Color;

/**
 * @author buseburcu
 */
public abstract class PropertyCard {

    // ATTRIBUTES
    private int sellPrice;
    private int mortgagePrice;
    private int[] rentPrices;

    private Player owner; // TODO fix this
    private String name;

    // CONSTRUCTOR
    protected PropertyCard(String name, int sellPrice, int mortgagePrice) {
        this.sellPrice = sellPrice;
        this.mortgagePrice = mortgagePrice;
        this.name = name;
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

    public abstract Color getColor();

    public String getName() {
        return name;
    }
}
