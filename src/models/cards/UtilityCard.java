package models.cards;

import gui.Color;
import gui.UtilityCardView;

import javax.swing.*;

/**
 * @author buseburcu
 */
public class UtilityCard extends PropertyCard {

    // ATTRIBUTES
    private UtilityCardView view;

    // CONSTRUCTOR
    public UtilityCard(int id, String name, int sellPrice, int mortgagePrice, int rent1, int rent2) {
        super(id, name, sellPrice, mortgagePrice);
        setRentPrices(rent1, rent2);

        this.view = new UtilityCardView(this);
    }

    // METHODS
    @Override
    public int getRentPrice(int nrOfUtilities) {
        return getRentPrices()[nrOfUtilities - 1];
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
