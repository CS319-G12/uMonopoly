package models.factories;

import models.cards.RailroadsCard;
import models.squares.RailroadsSquare;
import models.squares.SquareType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alper Önder
 */
public class RailroadsFactory implements PropertyFactory {
    // ATTRIBUTES
    List<RailroadsSquare> squares;

    // CONSTRUCTOR
    public RailroadsFactory(){
        squares = new ArrayList<>();

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
    }

    // METHODS
    @Override
    public List getSquares(){
        return squares;
    }
}
