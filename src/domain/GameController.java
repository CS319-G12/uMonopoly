package domain;

import gui.PlayerRegistrationSection;
import storage.Rules;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anikristo
 */
public class GameController {

    // ATTRIBUTES
    private Map<String, Player> players;

    // CONSTRUCTOR
    public GameController() {
        players = new HashMap<>(Rules.MAX_PLAYERS);
    }

    // METHODS
    public void createPlayerDetails(String name, String tokenFigure) throws PlayerRegistrationSection.NameNotUniqueException {
        // TODO replace with enum

        if (players.containsKey(name))
            throw new PlayerRegistrationSection.NameNotUniqueException();

        players.put(name, new Player(name, tokenFigure));
    }

    public void startGame() throws PlayerRegistrationSection.TooFewPlayersException {
        // TODO create MonopolyBoard
        // TODO create side panel
        // TODO timer ?

        if (players.size() < Rules.MIN_PLAYERS)
            throw new PlayerRegistrationSection.TooFewPlayersException();
    }

    public void removePlayer(String name) {
        players.remove(name);
    }
}
