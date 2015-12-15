package models.squares;

import models.Player;
import models.cards.RailroadsCard;

/**
 * @author Alper Önder
 */
public class RailroadsSquare extends Square implements PropertySquare {

    // ATTRIBUTES
    private final RailroadsCard theRailroadsCard;
    private PropertyGroup<RailroadsSquare> group;

    // CONSTRUCTOR
    public RailroadsSquare(int position, RailroadsCard theRailroadsCard) {
        super(position, theRailroadsCard.getName(), SquareType.RAILROADS);
        this.theRailroadsCard = theRailroadsCard;
    }

    // METHODS
    @Override
    public int getRentPrice() {
        Player owner = theRailroadsCard.getOwner();
        ;
        if (owner == null)
            return 0;
        else
            return theRailroadsCard.getRentPrice(group.getNumberOfOwnedProperties(owner));
    }

    @Override
    public RailroadsCard getCard() {
        return theRailroadsCard;
    }

    @Override
    public void setOwner(Player currentPlayer) {
        theRailroadsCard.setOwner(currentPlayer);
        group.setOwner(this, currentPlayer);
    }

    @Override
    public void removeOwner() {
        theRailroadsCard.removeOwner();
        group.removeOwner(this);
    }

    @Override
    public boolean hasOwner() {
        return theRailroadsCard.getOwner() != null;
    }

    @Override
    public boolean isOwner(Player p) {
        return theRailroadsCard.getOwner() == p;
    }

    @Override
    public  PropertyGroup<RailroadsSquare> getGroup() {
        return group;
    }

    @Override
    public void setGroup(PropertyGroup propertyGroup) {
        this.group = propertyGroup;
    }
}
