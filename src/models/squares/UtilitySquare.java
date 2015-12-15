package models.squares;

import models.Player;
import models.cards.UtilityCard;

/**
 * @author Alper Önder
 */
public class UtilitySquare extends Square implements PropertySquare {

    // ATTRIBUTES
    private final UtilityCard theUtilityCard;

    private PropertyGroup<UtilitySquare> group;

    // CONSTRUCTOR
    public UtilitySquare(int position, SquareType type, UtilityCard theUtilityCard) {
        super(position, theUtilityCard.getName(), type);
        this.theUtilityCard = theUtilityCard;
    }

    // METHODS
    @Override
    public int getRentPrice() {
        Player p = theUtilityCard.getOwner();
        if (p == null)
            return 0;
        if (group.ownsAllProperties(p))
            return theUtilityCard.getRentPrice(2);
        else
            return theUtilityCard.getRentPrice(1);
    }

    @Override
    public UtilityCard getCard() {
        return theUtilityCard;
    }

    @Override
    public void setOwner(Player currentPlayer) {
        theUtilityCard.setOwner(currentPlayer);
        group.setOwner(this, currentPlayer);
    }

    @Override
    public void removeOwner() {
        theUtilityCard.removeOwner();
        group.removeOwner(this);
    }

    @Override
    public boolean hasOwner() {
        return theUtilityCard.getOwner() != null;
    }

    @Override
    public boolean isOwner(Player p) {
        return theUtilityCard.getOwner() == p;
    }

    @Override
    public PropertyGroup<UtilitySquare> getGroup() {
        return group;
    }

    @Override
    public <T extends PropertySquare> void setGroup(PropertyGroup propertyGroup) {
        this.group = propertyGroup;
    }
}
