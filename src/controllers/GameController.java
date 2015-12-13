package controllers;

import gui.PlayerRegistrationSection;
import models.Game;
import models.Rules;
import models.token.TokenFigure;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anikristo & Alper Önder
 */
public class GameController {

    // ATTRIBUTES
    private Game game;
    private HelpController helpController;

    private Map<String, TokenFigure> playerDetails;

    // CONSTRUCTOR
    public GameController(HelpController helpController) {
        this.helpController = helpController;
        this.playerDetails = new HashMap<>(Rules.MAX_PLAYERS);
    }

    // METHODS
    public void createPlayerDetails(String name, TokenFigure tokenFigure)
            throws PlayerRegistrationSection.NameNotUniqueException {
        if (playerDetails.containsKey(name))
            throw new PlayerRegistrationSection.NameNotUniqueException();
        playerDetails.put(name, tokenFigure);
    }

    /**
     * @throws PlayerRegistrationSection.TooFewPlayersException
     * @pre self.game == null
     * @post self.game != null
     */
    public void startGame() throws PlayerRegistrationSection.TooFewPlayersException {

        // Checking the minimum number of players is satisfied
        if (playerDetails.size() < Rules.MIN_PLAYERS)
            throw new PlayerRegistrationSection.TooFewPlayersException();

        game = new Game(this, helpController, playerDetails);

        game.start();
    }

    public void removePlayer(String name) {
        playerDetails.remove(name);
    }

    /**
     * @pre game.getPlayer(currentPlayer).getBudget() >= game.getSquare(currentSquare).getPrice()
     * @pre !game.getPlayer(currentPlayer).ownsProperty(game.getSquare(currentSquare))
     * @post game.getPlayer(currentPlayer).ownsProperty(game.getSquare(currentSquare))
     */
    public void buyProperty() throws Game.NotBuyableException{
            game.buyProperty();
    }

    /**
     * @pre game.getPlayer(currentPlayer).ownsProperty(game.getSquare(currentSquare))
     * @post !game.getPlayer(currentPlayer).ownsProperty(game.getSquare(currentSquare))
     */
    public void sellProperty() throws Game.NotSellableException{
        game.sellProperty();
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

    public void roll() {
        // TODO roll, move the token, update curren squares....
    }

    public void endTurn() {
        // TODO update turn, update current player and views of the current square and list of property cards ownned
    }

    public void build() throws Game.NotBuildableException{
        game.build();
        // TODO Update views
    }

}
