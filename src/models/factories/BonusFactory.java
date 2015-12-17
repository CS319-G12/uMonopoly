package models.factories;

import models.squares.Square;

import java.util.Set;

/**
 * @author Ani Kristo
 */
interface BonusFactory {
    Set<? extends Square> makeSquares();
}
