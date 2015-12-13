package models.factories;

import models.cards.RailroadsCard;
import models.squares.PropertyGroup;
import models.squares.PropertyGroupType;
import models.squares.RailroadsSquare;
import models.squares.SquareType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alper Önder
 */
public class RailroadsFactory implements PropertyFactory {
    // ATTRIBUTES
    Set<RailroadsSquare> squares;

    // CONSTRUCTOR
    public RailroadsFactory(){
        squares = new HashSet<>();

        RailroadsCard card1 = new RailroadsCard("READING RAILROAD",200, 100, 25,50,100,200);
        RailroadsCard card2 = new RailroadsCard("PENNSYLVANIA RAILROAD",200, 100, 25,50,100,200);
        RailroadsCard card3 = new RailroadsCard("B. 'n O. RAILROAD",200, 100, 25,50,100,200);
        RailroadsCard card4 = new RailroadsCard("SHORT LINE",200, 100, 25,50,100,200);

        RailroadsSquare square1 = new RailroadsSquare(5, SquareType.RAILROADS, card1);
        RailroadsSquare square2 = new RailroadsSquare(15, SquareType.RAILROADS, card2);
        RailroadsSquare square3 = new RailroadsSquare(25, SquareType.RAILROADS, card3);
        RailroadsSquare square4 = new RailroadsSquare(35, SquareType.RAILROADS, card4);

        squares.add(square1);
        squares.add(square2);
        squares.add(square3);
        squares.add(square4);

        new PropertyGroup<RailroadsSquare>(PropertyGroupType.RAILROADS, Arrays.asList(square1, square2,square3, square4));
    }

    // METHODS
    @Override
    public Set<RailroadsSquare> getSquares() {
        return squares;
    }
}
