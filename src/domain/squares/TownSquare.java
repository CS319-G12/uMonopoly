package domain.squares;

import domain.cards.TownCard;
import gui.Color;
import storage.Rules;

/**
 * @author Alper Önder
 * Town Square class is the class for manage the towns in the game.  It holds color of the town,
 * card of the town which has diffrent properties for each town.
 * Building house and hotel can be done in this class.
 */
public class TownSquare extends Square implements PropertySquare {

    // ATTRIBUTES
    private final Color color;
    private final TownCard theTownCard;

    public int houseCount;
    public boolean hotel;

    // CONSTRUCTOR
    public TownSquare(int position, String name, SquareType type, Color color, int houseCount, boolean hotel, TownCard theTownCard) {
        super(position, name, type);
        this.color = color;
        this.houseCount = houseCount;
        this.hotel = hotel;
        this.theTownCard = theTownCard;
    }

    // METHODS
    /**
     * @pre self.houseCount < Rules.MAX_HOUSE_COUNT
     * @pre self.hotel == false
     * @post self.houseCount == self@pre.houseCount+1
     * @throws CannotBuildHouseException
     */
    public void addHouse() throws CannotBuildHouseException {
        if (houseCount < Rules.MAX_HOUSE_COUNT && !hotel)
            houseCount++;
        else
            throw new CannotBuildHouseException();
    }

    /**
     * @pre self.houseCount == Rules.MAX_HOUSE_COUNT
     * @pre self.hotel == false
     * @post self.hotel == true
     * @post self.houseCount == 0
     * @throws CannotBuildHouseException
     */
    public void addHotel() throws CannotBuildHotelException {
        if (houseCount == Rules.MAX_HOUSE_COUNT && !hotel) {
            houseCount = 0;
            hotel = true;
        } else
            throw new CannotBuildHotelException();
    }

    public Color getColor() {
        return color;
    }

    public int getHouseCount() {
        return houseCount;
    }

    public boolean hasHotel() {
        return hotel;
    }

    public int getRentPrice(int numberOfBuilding) {
        return theTownCard.getRentPrice(numberOfBuilding);
    }

    public static class CannotBuildHouseException extends Exception {
        @Override
        public String getMessage() {
            return super.getClass().getName() + ", " + super.getMessage() + "No more than 4 houses can be built!";
        }
    }

    public static class CannotBuildHotelException extends Exception {
        @Override
        public String getMessage() {
            return super.getClass().getName() + ", " + super.getMessage() + "Not enough houses to build a Hotel!";
        }
    }
}
