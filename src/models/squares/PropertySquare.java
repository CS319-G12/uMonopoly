package models.squares;

import models.cards.PropertyCard;

/**
 * @author Alper Önder
 */
public interface PropertySquare {
    int getRentPrice(int numberOfBuildings);

    PropertyCard getPropertyCard();
}
