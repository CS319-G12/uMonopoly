package models.squares;

import models.Player;
import models.cards.PropertyCard;

/**
 * @author Alper Önder
 */
public interface PropertySquare {
    int getRentPrice(int numberOfBuildings);

    PropertyCard getCard();

    <T extends PropertySquare> void setGroup(PropertyGroup propertyGroup);
    <T extends PropertySquare> PropertyGroup<T>  getGroup();

    void setOwner(Player currentPlayer);

    void removeOwner();
}
