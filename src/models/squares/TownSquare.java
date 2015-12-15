package models.squares;

import gui.Color;
import models.Player;
import models.Rules;
import models.cards.TownCard;

/**
 * @author Alper Önder, Ani Kristo
 *         Town Square class is the class for manage the towns in the game.  It holds color of the town,
 *         card of the town which has diffrent properties for each town.
 *         Building house and hotel can be done in this class.
 */
public class TownSquare extends Square implements PropertySquare {

    // ATTRIBUTES
    private final Color color;
    private final TownCard theTownCard;
    private int nrOfHouses;
    private boolean hotel;
    private PropertyGroup<TownSquare> group;

    // CONSTRUCTOR
    public TownSquare(int position, TownCard theTownCard) {
        super(position, theTownCard.getName(), SquareType.TOWN);
        this.color = theTownCard.getColor();
        this.nrOfHouses = 0;
        this.hotel = false;
        this.theTownCard = theTownCard;
    }

    // METHODS
    public Color getColor() {
        return color;
    }

    public int getBuildingCount() {
        return hotel ? 1 : nrOfHouses;
    }

    public boolean hasHotel() {
        return hotel;
    }

    public int getRentPrice() {
        if (theTownCard.getOwner() == null)
            return 0;
        else if (group.ownsAllProperties(theTownCard.getOwner())
                && nrOfHouses == 0
                && !hotel) {
            // Twice the rent price
            return theTownCard.getRentPrice(0) * 2;

        } else if (hotel)
            return theTownCard.getHotelRentPrice();
        else
            return theTownCard.getRentPrice(nrOfHouses);
    }

    @Override
    public TownCard getCard() {
        return theTownCard;
    }

    @Override
    public void setOwner(Player currentPlayer) {
        theTownCard.setOwner(currentPlayer);
        group.setOwner(this, currentPlayer);
    }

    @Override
    public void removeOwner() {
        theTownCard.removeOwner();
        group.removeOwner(this);
    }

    @Override
    public boolean hasOwner() {
        return theTownCard.getOwner() != null;
    }

    @Override
    public boolean isOwner(Player p) {
        return theTownCard.getOwner() == p;
    }

    @Override
    public PropertyGroup<TownSquare> getGroup() {
        return group;
    }

    @Override
    public void setGroup(PropertyGroup propertyGroup) {
        this.group = propertyGroup;
    }

    public void removebuildings() {
        nrOfHouses = 0;
        hotel = false;
        notifyObservers();
    }

    /**
     * @throws CannotBuildException
     * @post self.nrOfHouses == self@pre.nrOfHouses+1 || self.nrOfHouses == self@pre.nrOfHouses+1
     */
    public void build() throws CannotBuildException {
        if (nrOfHouses < Rules.MAX_HOUSE_COUNT && !hotel)
            nrOfHouses++;
        else if (nrOfHouses == Rules.MAX_HOUSE_COUNT && !hotel) {
            nrOfHouses = 0;
            hotel = true;
        } else
            throw new CannotBuildException();

    }

    public boolean isFull() {
        return hotel && nrOfHouses == 0;
    }

    public boolean hasMonopoly(Player currentPlayer) {
        return group.ownsAllProperties(currentPlayer);
    }

    public static class CannotBuildException extends Exception {
        @Override
        public String getMessage() {
            return super.getClass().getName() + ", " + super.getMessage() + "Cannot build any house or hotel more!";
        }
    }

}
