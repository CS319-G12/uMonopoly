package models.cards;

import gui.Color;
import gui.RailroadsCardView;

/**
 * @author buseburcu
 */
public class RailroadsCard extends PropertyCard {

    // ATTRIBUTES
    private RailroadsCardView view;

    // CONSTRUCTOR
    public RailroadsCard(String name, int sellPrice, int mortgagePrice, int rent1, int rent2, int rent3, int rent4) {
        super(name, sellPrice, mortgagePrice);
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

    public RailroadsCardView getView() {
        return view;
    }
}
