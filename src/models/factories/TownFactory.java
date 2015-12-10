package models.factories;

import gui.Color;
import models.cards.TownCard;
import models.squares.SquareType;
import models.squares.TownSquare;

import java.util.List;

/**
 * @author anikristo
 */
public class TownFactory implements PropertyFactory {

    // ATTRIBUTES
    private List<TownSquare> squares;

    // CONSTRUCTOR
    public TownFactory() {

        // Instantiates the property cards
        TownCard card1 = new TownCard("MEDITERRANEAN AVENUE", Color.BROWN, );

        // Instantiate the squares
        TownSquare square1 = new TownSquare(1, SquareType.TOWN, card1);
        TownSquare square2 = new TownSquare(3, SquareType.TOWN, card2);
    }

    // METHOD
}
