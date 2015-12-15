package controllers;

import controllers.dbmanagement.DatabaseHelper;
import gui.PlayerRegistrationSection;
import models.Game;
import models.Player;
import models.Rules;
import models.squares.PropertySquare;
import models.squares.Square;
import models.squares.TownSquare;
import models.token.TokenFigure;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ani Kristo & Alper Önder
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
    public void buyProperty() throws Game.NotBuyableException {
        game.buyProperty();
    }

    /**
     * @pre game.getPlayer(currentPlayer).ownsProperty(game.getSquare(currentSquare))
     * @post !game.getPlayer(currentPlayer).ownsProperty(game.getSquare(currentSquare))
     */
    public void sellProperty() throws Game.NotSellableException {
        game.sellProperty();
    }

    public void viewHelp() {
        JFrame helpFrame = new JFrame("µMonopoly Help");
        helpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        helpFrame.setSize(1152, 730);
        helpFrame.setContentPane(game.getHelp().getView().getContent());
        helpFrame.setVisible(true);
    }

    public void endGame() {

        if (game.hasFinished()) {
            // TODO save high scores and exit
             game.getWinner();

            Date today = new Date();
            DateFormat dayMonthYearFormat = new SimpleDateFormat("dd/MM/yyyy");
            new DatabaseHelper().insertHighScoreToDB(game.getWinner().getName(), game.getWinner().getTokenFigure().getName(), game.getWinner().getBudget(), dayMonthYearFormat.format(today));
        } else {
            // Todo give
            JOptionPane exitQuestionJOP = new JOptionPane("Are you sure you want to exit?\nProgression and score will not be saved!", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
            JDialog exitQuestionJOPD = exitQuestionJOP.createDialog("Confirmation");
            exitQuestionJOPD.setAlwaysOnTop(true);
            exitQuestionJOPD.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            exitQuestionJOPD.show();
            int JOPSelectedOption= (int) exitQuestionJOP.getValue();
            if(JOPSelectedOption == JOptionPane.YES_OPTION){
                //setContentPane(mainScreen); // TODO
            }
        }
    }

    public Game getGame() {
        return game;
    }

    public void roll() {
        if (!game.playerRolled())
            game.roll();
    }

    public void endTurn() {
        game.endTurn();
    }

    public void build() throws Game.NotBuildableException {
        game.build();
        // TODO Update views
    }

    /**
     * Conditions: current player has not rolled before
     */
    public boolean canRoll() {
        return !game.playerRolled();
    }

    /**
     * Conditions:
     * 1. Current player rolled
     */
    public boolean canEndTurn() {
        return game.playerRolled();
    }

    /**
     * Conditions:
     * 1. Current square is a PropertySquare
     * 2. It is not owned
     * 3. Player has enough budget
     */
    public boolean canBuy() {
        Square currentSquare = game.getCurrentSquare();
        return currentSquare instanceof PropertySquare
                && ((PropertySquare) currentSquare).hasOwner()
                && game.getCurrentPlayer().getBudget() >= ((PropertySquare) currentSquare).getCard().getSellPrice();
    }

    /**
     * Conditions:
     * 1. Current square is a PropertySquare
     * 2. It is  owned by the current player
     */
    public boolean canSell() {
        Square currentSquare = game.getCurrentSquare();
        return currentSquare instanceof PropertySquare
                && ((PropertySquare) currentSquare).isOwner(game.getCurrentPlayer());
    }

    /**
     * Conditions:
     * 1. Current square is a TownSquare
     * 2. It is owned by the current player
     * 3. The player has enough budget
     * 4. There is space to build
     */
    public boolean canBuild() {
        Square currentSquare = game.getCurrentSquare();
        Player currentPlayer = game.getCurrentPlayer();
        return currentSquare instanceof TownSquare
                && ((TownSquare) currentSquare).isOwner(currentPlayer)
                && currentPlayer.getBudget() >= ((TownSquare) currentSquare).getCard().getHouseBuildPrice()
                && !((TownSquare) currentSquare).isFull();
    }
}
