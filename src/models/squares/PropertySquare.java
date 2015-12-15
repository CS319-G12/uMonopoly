package models.squares;

import models.Player;
import models.cards.PropertyCard;

/**
 * @author Alper Önder
 */
public interface PropertySquare {
    int getRentPrice();

    PropertyCard getCard();

    <T extends PropertySquare> PropertyGroup<T>  getGroup();

    <T extends PropertySquare> void setGroup(PropertyGroup propertyGroup);

    void setOwner(Player currentPlayer);

    void removeOwner();

    boolean hasOwner();

    boolean isOwner(Player p);
}
