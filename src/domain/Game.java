package domain;

import domain.squares.Square;
import domain.token.TokenFigure;
import gui.PlayerRegistrationSection;
import storage.Rules;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anikristo
 * @invariant self.turn >= 0 && self.turn < 4
 * @invariant self.currentSquares.size() == 4
 * @invariant self.players.size() > 1 && self.players.size() <= 4
 * @invariant self.playerNames.size() > 1 && self.playerNames.size() <= 4
 * @invariant self.players.size() == self.playerNames.size()
 */
public class Game {

    // ATTRIBUTES
    private int turn;
    private List<Square> currentSquares;

    private MonopolyBoard board;
    private List<Player> players;
    private List<String> playerNames;

    private GameController controller;


    // CONSTRUCTOR
    public Game() {
        players = new ArrayList<>(Rules.MAX_PLAYERS);
        playerNames = new ArrayList<>(Rules.MAX_PLAYERS);
    }

    // METHODS

    /**
     * This method adds a new player to the game
     *
     * @param name        the name of the player to be added as received from the GUI
     * @param tokenFigure the token figure selected from the player at registration
     * @throws PlayerRegistrationSection.NameNotUniqueException
     * @pre !playerNames->includes(name)
     * @post self.players.size() == self@pre.players.size() + 1
     * @post self.playerNames.size() == self@pre.playerNames.size() + 1
     */
    public void addPlayer(String name, TokenFigure tokenFigure) throws PlayerRegistrationSection.NameNotUniqueException {
        Player newPlayer = new Player(name, tokenFigure);
        if (players.contains(newPlayer))
            throw new PlayerRegistrationSection.NameNotUniqueException();
        else {
            players.add(newPlayer);
            playerNames.add(name);
        }
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    /**
     * @pre self.players.size() > 0
     * @pre self.playerNames->includes(name)
     * @post self.players.size() == self@pre.players.size() - 1
     * @post self.playerNames.size() == self@pre.playerNames.size() - 1
     * @param name The name of the player to be removed
     * @throws PlayerNotFoundException
     */
    public void removePlayer(String name) throws PlayerNotFoundException {
        players.remove(playerNames.indexOf(name));
        playerNames.remove(playerNames.indexOf(name));
    }

    public static class PlayerNotFoundException extends Exception {
        @Override
        public String getMessage() {
            return super.getMessage() + "The player is not registered in the game!";
        }
    }
}
