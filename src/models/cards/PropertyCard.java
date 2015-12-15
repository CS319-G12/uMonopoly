package models.cards;

import gui.Color;
import models.Player;

import javax.swing.*;

/**
 * @author buseburcu
 */
public abstract class PropertyCard {

    // CONSTANT UNIQUE ID
    private static int id_count = 0;

    // PROPERTIES
    private final int id;
    private int sellPrice;
    private int mortgagePrice;
    private int[] rentPrices;

    private Player owner;
    private String name;

    // CONSTRUCTOR
    PropertyCard(String name, int sellPrice, int mortgagePrice) {
        this.id = id_count++;
        this.sellPrice = sellPrice;
        this.mortgagePrice = mortgagePrice;
        this.name = name;

        this.owner = null;
    }

    // METHODS
    public int getID() {
        return id;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public int getMortgagePrice() {
        return mortgagePrice;
    }

    int[] getRentPrices() {
        return rentPrices;
    }

    void setRentPrices(int... rents) {
        rentPrices = rents;
    }

    public abstract int getRentPrice(int number);

    public abstract Color getColor();

    public String getName() {
        return name;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player p) {
        owner = p;
    }

    public void removeOwner() {
        owner = null;
    }

    public abstract JPanel getView();
}
