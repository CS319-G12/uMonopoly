package domain.squares;

import domain.cards.TownCard;

import java.awt.Color;

/**
 * Created by Alper Önder
 */
public class TownSquare extends PropertySquare {

    // ATTRIBUTES
    private Color    color;
    public  int      houseCount;
    public  boolean  hotel;
    private TownCard card;

    // CONSTRUCTOR
    public TownSquare(int id, int position, String name, SquareType type, Color color, int houseCount, boolean hotel, TownCard card){
        super(id, position, name, type);
        this.color      = color;
        this.houseCount = houseCount;
        this.hotel      = hotel;
        this.card       = card;
    }

    // METHODS
    public void addHouse(){
        // TODO
    }

    public void addHotel(){
        // TODO
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

    public int getRentPrice(){
        // TODO
        return 0;
    }

}
