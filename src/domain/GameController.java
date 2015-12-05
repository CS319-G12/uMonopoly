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
    private int currentPlayer;

    // CONSTRUCTOR
    public GameController() {
        game = new Game();// todo null not new
    }

    // METHODS
    public void createPlayerDetails(String name, TokenFigure tokenFigure) throws PlayerRegistrationSection.NameNotUniqueException {
        game.addPlayer(name, tokenFigure);
    }

    /**
     * @throws PlayerRegistrationSection.TooFewPlayersException
     * @pre self.game == null
     * @post self.game != null
     */
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

    /**
     * @pre game.getPlayer(currentPlayer).getBudget() >= game.getSquare(currentSquare).getPrice()
     * @pre !game.getPlayer(currentPlayer).ownsProperty(game.getSquare(currentSquare))
     * @post game.getPlayer(currentPlayer).ownsProperty(game.getSquare(currentSquare))
     */
    public void buyProperty() {
        // Todo
    }

    /**
     * @pre game.getPlayer(currentPlayer).ownsProperty(game.getSquare(currentSquare))
     * @post !game.getPlayer(currentPlayer).ownsProperty(game.getSquare(currentSquare))
     */
    public void sellProperty() {
        // todo
    }
}
