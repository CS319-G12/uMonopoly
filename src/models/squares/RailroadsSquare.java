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
    public RailroadsSquare(int position, SquareType type, RailroadsCard theRailroadsCard){
        super(position, theRailroadsCard.getName(), type);
        this.theRailroadsCard = theRailroadsCard;
    }

    // METHODS
    @Override
    public int getRentPrice(int numberOfBuildings){
        return theRailroadsCard.getRentPrice(numberOfBuildings);
    }

    @Override
    public RailroadsCard getCard() {
        return theRailroadsCard;
    }

    @Override
    public <T extends PropertySquare> void setGroup(PropertyGroup propertyGroup) {
        this.group = propertyGroup;
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
    public  PropertyGroup<RailroadsSquare> getGroup() {
        return group;
    }
}
