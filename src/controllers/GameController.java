package controllers;

import gui.PlayerRegistrationSection;
import models.Game;
import models.Rules;
import models.token.TokenFigure;

import javax.swing.*;

/**
 * @author anikristo
 */
public class GameController {

    // ATTRIBUTES
    private Game game;

    // CONSTRUCTOR
    public GameController(HelpController helpController) {
        game = new Game(this, helpController);
    }

    // METHODS
    public void createPlayerDetails(String name, TokenFigure tokenFigure)
            throws PlayerRegistrationSection.NameNotUniqueException {
        game.addPlayer(name, tokenFigure);
    }

    /**
     * @throws PlayerRegistrationSection.TooFewPlayersException
     * @pre self.game == null
     * @post self.game != null
     */
    public void startGame() throws PlayerRegistrationSection.TooFewPlayersException {
        // Checking the minimum number of players is satisfied
        if (game.getNumberOfPlayers() < Rules.MIN_PLAYERS)
            throw new PlayerRegistrationSection.TooFewPlayersException();

        game.start();

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

    public void viewHelp() {
        JFrame helpFrame = new JFrame("µMonopoly Help");
        helpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        helpFrame.setSize(1152, 720);
        helpFrame.setContentPane(game.getHelp().getView().getContent());
        helpFrame.setVisible(true);
    }

    public void endGame() {

        if (game.hasFinished()) {
            // TODO save high scores and exit
        } else {
            // Todo give warning
        }
    }

    public Game getGame() {
        return game;
    }
}
