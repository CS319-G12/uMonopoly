package models.cards;

import gui.Color;
import gui.RailroadsCardView;

import javax.swing.*;

/**
 * @author buseburcu
 */
public class RailroadsCard extends PropertyCard {

    // ATTRIBUTES
    private RailroadsCardView view;

    // CONSTRUCTOR
    public RailroadsCard(int id, String name, int sellPrice, int mortgagePrice, int rent1, int rent2, int rent3, int rent4) {
        super(id, name, sellPrice, mortgagePrice);
        setRentPrices(rent1, rent2, rent3, rent4);

        this.view = new RailroadsCardView(this);
    }

    //
    @Override
    public int getRentPrice(int nrOfStations) {
        return getRentPrices()[nrOfStations - 1];
    }

    @Override
    public Color getColor() {
        return Color.CHARCOAL;
    }

    @Override
    public JPanel getView() {
        return view.getContent();
    }
}
