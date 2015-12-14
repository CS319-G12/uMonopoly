package models.factories;

import models.cards.UtilityCard;
import models.squares.PropertyGroup;
import models.squares.PropertyGroupType;
import models.squares.SquareType;
import models.squares.UtilitySquare;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alper Önder
 */
public class UtilityFactory implements PropertyFactory {
    // ATTRIBUTES
    private Set<UtilitySquare> squares;

    // CONSTRUCTOR
    public UtilityFactory(){
        squares = new HashSet<>();

        UtilityCard card1 = new UtilityCard("ELECTRIC COMPANY", 150, 75, 4, 10);
        UtilityCard card2 = new UtilityCard("WATER WORKS", 150, 75, 4, 10);

        UtilitySquare square1 = new UtilitySquare(12 ,SquareType.ELECTRIC_COMPANY, card1);
        UtilitySquare square2 = new UtilitySquare(28 ,SquareType.WATER_WORKS, card2);

        squares.add(square1);
        squares.add(square2);

        new PropertyGroup<UtilitySquare>(PropertyGroupType.UTILITY, Arrays.asList(square1,  square2));
    }
    // METHODS
    @Override
    public Set<UtilitySquare> getSquares() {
        return squares;
    }
}

