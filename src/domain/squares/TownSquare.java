package domain.squares;

import domain.cards.TownCard;
import gui.Color;

/**
 * @author Alper Önder
 */
public class TownSquare extends PropertySquare {

    // ATTRIBUTES
    private Color color;
    public  int      houseCount;
    public  boolean  hotel;
    private TownCard theTownCard;

    // CONSTRUCTOR
    public TownSquare(int position, String name, SquareType type, Color color, int houseCount, boolean hotel, TownCard theTownCard){
        super(position, name, type);
        this.color        = color;
        this.houseCount   = houseCount;
        this.hotel        = hotel;
        this.theTownCard  = theTownCard;
    }

    // METHODS
    public void addHouse() throws CannotBuildHouseException {
        if(houseCount < 4 && !hotel)
            houseCount++;
        else
            throw new CannotBuildHouseException();
    }

    public void addHotel() throws CannotBuildHotelException{
        if(houseCount == 4 && !hotel){
            houseCount = 0;
            hotel = true;
        }
        else
            throw new CannotBuildHotelException();
    }

    public Color getColor(){
        return color;
    }

    public int getHouseCount(){
        return houseCount;
    }

    public boolean hasHotel(){
        return hotel;
    }

    public int getRentPrice(int numberOfBuilding){
        return theTownCard.getRentPrice(numberOfBuilding);
    }

    public static class CannotBuildHouseException extends Throwable {
        @Override
        public String getMessage() {
            return super.getClass().getName() + ", " + super.getMessage() + "No more than 4 houses can be built!";
        }
    }

    public static class CannotBuildHotelException extends Throwable {
        @Override
        public String getMessage() {
            return super.getClass().getName() + ", " + super.getMessage() + "Not enough houses to build a Hotel!";
        }
    }
}
