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

    void removeOwner();

    boolean hasOwner();

    boolean isOwner(Player p);

    Player getOwner();

    void setOwner(Player currentPlayer);
}
