package domain.cards;

import gui.Color;
import gui.UtilityCardView;

/**
 * @author buseburcu
 */
public class UtilityCard extends PropertyCard {

    // ATTRIBUTES
    private UtilityCardView view; // TODO

    // CONSTRUCTOR
    public UtilityCard(String name, int sellPrice, int mortgagePrice, int rent1, int rent2) {
        super(name, sellPrice, mortgagePrice);

        setRentPrices(rent1, rent2);
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
}
