package domain;

import domain.squares.Square;
import domain.token.TokenFigure;
import gui.PlayerRegistrationSection;
import storage.Rules;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anikristo
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
