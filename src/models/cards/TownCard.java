package models.cards;

import gui.Color;
import gui.TownCardView;

import javax.swing.*;

/**
 * @author buseburcu
 */
public class TownCard extends PropertyCard {

    // ATTRIBUTES
    private int housePrice;
    private int hotelPrice;
    private Color color;

    private TownCardView view;

    // CONSTRUCTOR
    public TownCard(int id, String name, Color color, int sellPrice, int mortgagePrice, int rent0, int rent1, int rent2, int rent3, int rent4, int rentHotel, int housePrice, int hotelPrice) {
        super(id, name, sellPrice, mortgagePrice);

        this.color = color;
        setRentPrices(rent0, rent1, rent2, rent3, rent4, rentHotel);
        this.housePrice = housePrice;
        this.hotelPrice = hotelPrice;

        this.view = new TownCardView(this);
    }

    // METHODS
    public int getRentPrice(int nrOfHouses) throws IllegalArgumentException {
        if (nrOfHouses > 4)
            throw new IllegalArgumentException();
        return getRentPrices()[nrOfHouses];
    }

    @Override
    public Color getColor() {
        return color;
    }

    public int getHotelRentPrice() {
        return getRentPrices()[5];
    }

    public int getHouseBuildPrice() {
        return housePrice;
    }

    public int getHotelBuildPrice() {
        return hotelPrice;
    }

    @Override
    public JPanel getView() {
        return view.getContent();
    }
}
