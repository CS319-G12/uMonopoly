package domain.cards;

import gui.TownCardView;

/**
 * @author buseburcu
 */
public class TownCard extends PropertyCard {

    // ATTRIBUTES
    private int housePrice;
    private int hotelPrice;

    private TownCardView view; // TODO

    // CONSTRUCTOR
    public TownCard(int sellPrice, int mortgagePrice, int rent0, int rent1, int rent2, int rent3, int rent4, int rentHotel) {
        super(sellPrice, mortgagePrice);

        setRentPrices(rent0, rent1, rent2, rent3, rent4, rentHotel);
    }

    // METHODS
    public int getRentPrice(int nrOfHouses) throws IllegalArgumentException {
        if (nrOfHouses > 4)
            throw new IllegalArgumentException();
        return getRentPrices()[nrOfHouses];
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

}
