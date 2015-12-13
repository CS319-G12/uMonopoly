package models.squares;

import models.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alper Önder
 */
public class PropertyGroup<T extends PropertySquare> {

    // ATTRIBUTES
    private PropertyGroupType    type;
    private List<T> properties;
    private List<Player>         players;

    // CONSTRUCTOR
    public PropertyGroup(PropertyGroupType type, List<T> properties){
        this.type       = type;
        this.properties = properties;
        this.players    = new ArrayList<>(properties.size());

        for(T property : properties){
            property.setGroup(this);
        }

        for(int i = 0; i < properties.size(); i++){
            players.add(null); //TODO
        }
    }

    // METHODS
    public boolean ownsAllProperties(Player thePlayer){
        for(Player a : players)
            if(!a.equals(thePlayer))
                return false;
        return true;
    }

    public PropertyGroupType getType(){
        return type;
    }

    public void setOwner(T propertySquare, Player currentPlayer) {
        players.set(properties.indexOf(propertySquare),currentPlayer);
    }

    public void removeOwner(T propertySquare) {
        players.set(properties.indexOf(propertySquare), null);
    }
}
