package models.factories;

import models.cards.UtilityCard;
import models.squares.SquareType;
import models.squares.UtilitySquare;

import java.util.ArrayList;
import java.util.List;

/**
 * @Alper Önder
 */
public class UtilityFactory implements PropertyFactory {
    // ATTRIBUTES
    List<UtilitySquare> squares;

    // CONSTRUCTOR
    public UtilityFactory(){
        squares = new ArrayList<>();

        UtilityCard card1 = new UtilityCard("Electric Company", 150, 75 , 4, 10);
        UtilityCard card2 = new UtilityCard("Water Works", 150 , 75, 4, 10);

        UtilitySquare square1 = new UtilitySquare(12 ,SquareType.ELECTRIC_COMPANY, card1);
        UtilitySquare square2 = new UtilitySquare(28 ,SquareType.WATER_WORKS, card2);

        squares.add(square1);
        squares.add(square2);
    }
    // METHODS
    @Override
    public List getSquares(){
        return squares;
    }
}

