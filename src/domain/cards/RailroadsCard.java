package domain.cards;

import gui.RailroadsCardView;

/**
 * @author buseburcu
 */
public class RailroadsCard extends PropertyCard {

    // ATTRIBUTES
    private RailroadsCardView view; // TODO

    // CONSTRUCTOR
    public RailroadsCard(int sellPrice, int mortgagePrice, int rent1, int rent2, int rent3, int rent4) {
        super(sellPrice, mortgagePrice);

        setRentPrices(rent1, rent2, rent3, rent4);
    }

    //
    @Override
    public int getRentPrice(int nrOfStations) {
        return getRentPrices()[nrOfStations - 1];
    }
}
