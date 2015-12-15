package controllers;

import controllers.dbmanagement.DatabaseHelper;
import gui.PlayerRegistrationSection;
import models.Game;
import models.Player;
import models.Rules;
import models.cards.BonusCard;
import models.squares.*;
import models.token.TokenFigure;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
     * PRE: self.game == null
     * POST: self.game != null
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
     * PRE: game.getPlayer(currentPlayer).getBudget() >= game.getSquare(currentSquare).getPrice()
     * PRE: !game.getPlayer(currentPlayer).ownsProperty(game.getSquare(currentSquare))
     * POST: game.getPlayer(currentPlayer).ownsProperty(game.getSquare(currentSquare))
     */
    public void buyProperty() throws Game.NotBuyableException {
        game.buyProperty();
    }

    /**
     * PRE: game.getPlayer(currentPlayer).ownsProperty(game.getSquare(currentSquare))
     * POST: !game.getPlayer(currentPlayer).ownsProperty(game.getSquare(currentSquare))
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
            // TODO show a dialog for information
            // TODO disable buttons
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
        if (canRoll())
            game.roll();

        checkLandingSquare();
    }

    private void checkLandingSquare() {
        Player p = game.getCurrentPlayer();
        Square s = game.getCurrentSquare();

        // Town Squares
        if (s instanceof TownSquare) {
            if (((TownSquare) s).hasOwner() && !((TownSquare) s).isOwner(p)) {
                int amount = ((TownSquare) s).getRentPrice();
                p.updateBudget(-amount);
                ((TownSquare) s).getOwner().updateBudget(amount);
            }
        }

        // Utility Squares
        else if (s instanceof UtilitySquare) {
            if (((UtilitySquare) s).hasOwner() && !((UtilitySquare) s).isOwner(p)) {
                int amount = ((UtilitySquare) s).getRentPrice() * (p.getDiceValue1().getValue() + p.getDiceValue2().getValue());
                p.updateBudget(-amount);
                ((UtilitySquare) s).getOwner().updateBudget(amount);
            }
        }

        // Railroads Squares
        else if (s instanceof RailroadsSquare) {
            if (((RailroadsSquare) s).hasOwner() && !((RailroadsSquare) s).isOwner(p)) {
                int amount = ((RailroadsSquare) s).getRentPrice();
                p.updateBudget(-amount);
                ((RailroadsSquare) s).getOwner().updateBudget(amount);
            }
        }

        // Chance Squares
        else if (s instanceof ChanceCardSquare) {
            applyBonusCard(((ChanceCardSquare) s).pickCard(), s, p);
        }

        // Community Chest Squares
        else if (s instanceof CommunityChestCardSquare) {
            applyBonusCard(((CommunityChestCardSquare) s).pickCard(), s, p);
        }

        // Tax Squares
        else if (s instanceof TaxSquare) {
            p.updateBudget(-((TaxSquare) s).getTaxAmount());
        }

        // Corner Squares
        else {
            if (s.getPosition() == Rules.GO_POSITION) {
                p.updateBudget(Rules.SALARY);

            } else if (s.getPosition() == Rules.JAIL_POSITION) {
                p.setPosition(Rules.JAIL_POSITION);
                p.setInJail(true);
            }
        }

        if (p.getBudget() <= 0)
            p.lost();

        // Checking if game has ended
        int numberOfLostPlayers = 0;
        List<Player> playersList = game.getListOfPlayers();
        for (Player player : playersList)
            if (player.hasLost())
                numberOfLostPlayers++;
        if (numberOfLostPlayers == playersList.size() - 1) {
            game.finished();
            endGame();
        }

        game.notifyObservers();
    }

    private void applyBonusCard(BonusCard card, Square s, Player p) {
        // TODO
    }

    public void endTurn() {
        game.endTurn();
    }

    public void build() throws Game.NotBuildableException {
        game.build();
    }

    /**
     * Conditions:
     * 1. Current player has not rolled before
     * OR
     * 2. Current player has rolled before and it was doubles
     */
    public boolean canRoll() {
        return !game.playerRolled() || (game.playerRolled() && game.playerHadDoubles());
    }

    /**
     * Conditions:
     * 1. Current player rolled and it wasn't doubles
     *
     */
    public boolean canEndTurn() {
        return !canRoll();
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
                && !((PropertySquare) currentSquare).hasOwner()
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
     * 2. The current player owns the monopoly
     * 3. The player has enough budget
     * 4. There is space to build
     */
    public boolean canBuild() {
        Square currentSquare = game.getCurrentSquare();
        Player currentPlayer = game.getCurrentPlayer();
        return currentSquare instanceof TownSquare
                && ((TownSquare) currentSquare).hasMonopoly(currentPlayer)
                && currentPlayer.getBudget() >= ((TownSquare) currentSquare).getCard().getHouseBuildPrice()
                && !((TownSquare) currentSquare).isFull();
    }
}
