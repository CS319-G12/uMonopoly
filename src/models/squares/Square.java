package models.squares;

import models.Player;
import models.Rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author Alper Önder
 */
public class Square extends Observable{

    // ATTRIBUTES
    private static int id_counter = 0;
    private final int id;
    private final int position;
    private final String name;
    private final SquareType type;
    private List<Player> residingPlayers;

    // CONSTRUCTOR
    public Square(int position, String name, SquareType type) {
        this.id = id_counter++;
        this.position = position;
        this.name = name;
        this.type = type;

        this.residingPlayers = new ArrayList<>(Rules.MAX_PLAYERS);
    }

    // METHODS
    public String getName() {
        return name;
    }

    public SquareType getSquareType() {
        return type;
    }

    public int getPosition() {
        return position;
    }

    public void addResidingPlayer(Player p) {
        residingPlayers.add(p);
        setChanged();
        notifyObservers();
    }

    public List<Player> getResidingPlayers() {
        return residingPlayers;
    }

    public void clearResidingPlayers() {
        residingPlayers.clear();
        setChanged();
        notifyObservers();
    }
}
