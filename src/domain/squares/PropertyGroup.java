package domain.squares;

import domain.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alper Önder
 */
public class PropertyGroup {

    // ATTRIBUTES
    private PropertyGroupType    type;
    private List<PropertySquare> properties;
    private List<Player>         players;

    // CONSTRUCTOR
    public PropertyGroup(PropertyGroupType type, List<PropertySquare> properties){
        this.type       = type;
        this.properties = properties;
        this.players    = new ArrayList<>(properties.size());
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
}
