package models.squares;

import models.cards.BonusCard;

/**
 * @author Alper Önder
 */
abstract class CardSquare extends Square {

    // CONSTRUCTOR
    CardSquare(int position, String name, SquareType type) {
        super(position, name, type);
    }

    // METHODS
    public abstract BonusCard pickCard();

    public abstract BonusCard getCard();
}
