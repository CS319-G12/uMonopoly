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
    public int houseCount;
    public boolean hotel;
    private PropertyGroup<TownSquare> group;

    // CONSTRUCTOR
    public TownSquare(int position, SquareType type, TownCard theTownCard) {
        super(position, theTownCard.getName(), type);
        this.color = theTownCard.getColor();
        this.houseCount = 0;
        this.hotel = false;
        this.theTownCard = theTownCard;
    }

    // METHODS
    public Color getColor() {
        return color;
    }

    public int getBuildingCount() {
        return hotel ? 1 : houseCount;
    }

    public boolean hasHotel() {
        return hotel;
    }

    public int getRentPrice(int numberOfBuilding) {
        return theTownCard.getRentPrice(numberOfBuilding);
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
    public <T extends PropertySquare> void setGroup(PropertyGroup propertyGroup) {
        this.group = propertyGroup;
    }

    public void removeBuidlings() {
        houseCount = 0;
        hotel      = false;
        notifyObservers();
    }

/**
 * @throws CannotBuildException
 * @post self.houseCount == self@pre.houseCount+1 || self.houseCount == self@pre.houseCount+1
 */
    public void build() throws CannotBuildException {
        if (houseCount < Rules.MAX_HOUSE_COUNT && !hotel)
            houseCount++;
        else if (houseCount == Rules.MAX_HOUSE_COUNT && !hotel) {
            houseCount = 0;
            hotel = true;
        } else
            throw new CannotBuildException();

    }

    public boolean isFull() {
        return hotel && houseCount == 0;
    }

    public static class CannotBuildException extends Exception {
        @Override
        public String getMessage() {
            return super.getClass().getName() + ", " + super.getMessage() + "Cannot build any house or hotel more!";
        }
    }

}
