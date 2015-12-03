package domain;

import domain.token.TokenFigure;
import gui.PlayerRegistrationSection;
import storage.Rules;

/**
 * @author anikristo
 */
public class GameController {

    // ATTRIBUTES
    private Game game;

    // CONSTRUCTOR
    public GameController() {
        game = new Game();// todo
    }

    // METHODS
    public void createPlayerDetails(String name, TokenFigure tokenFigure) throws PlayerRegistrationSection.NameNotUniqueException {
        game.addPlayer(name, tokenFigure);
    }

    public void startGame() throws PlayerRegistrationSection.TooFewPlayersException {
        // TODO create Game

        // Checking the minimum number of players is satisfied
        if (game.getNumberOfPlayers() < Rules.MIN_PLAYERS)
            throw new PlayerRegistrationSection.TooFewPlayersException();

        // Creating the MonopolyBoard

    }

    public void removePlayer(String name) {
        try {
            game.removePlayer(name);
        } catch (Game.PlayerNotFoundException e) {
            System.out.println("The player was not registered!");// todo
        }
    }
}
