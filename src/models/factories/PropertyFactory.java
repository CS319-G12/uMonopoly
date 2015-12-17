package models.factories;

import models.squares.PropertySquare;

import java.util.Set;

/**
 * @author Ani Kristo
 */
interface PropertyFactory {
    Set<? extends PropertySquare> makeSquares();
}
