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
            int selection = JOptionPane.showConfirmDialog(null, "Confirmation", "Are you sure you want to exit?", JOptionPane.YES_NO_OPTION);
            if(selection == JOptionPane.YES_OPTION){
//                setContentPane(mainScreen); TODO
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
            // TODO
            if (!((TownSquare) s).isOwner(p)) {
                p.updateBudget(-((TownSquare) s).getRentPrice());
            }
        }

        // Utility Squares
        else if (s instanceof UtilitySquare) {
            // TODO
            if (!((UtilitySquare) s).isOwner(p)) {
                p.updateBudget(-((UtilitySquare) s).getRentPrice() * (p.getDiceValue1().getValue() + p.getDiceValue2().getValue()));
            }
        }

        // Railroads Squares
        else if (s instanceof RailroadsSquare) {
            // TODO
            if (!((RailroadsSquare) s).isOwner(p)) {
                p.updateBudget(-((RailroadsSquare) s).getRentPrice());
            }
        }

        // Chance Squares
        else if (s instanceof ChanceCardSquare) {
            // TODO just getCard afterwards
            applyBonusCard(((ChanceCardSquare) s).pickCard(), s, p);
        }

        // Community Chest Squares
        else if (s instanceof CommunityChestCardSquare) {
            // TODO just getCard afterwards
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

        // TODO
        if (p.getBudget() <= 0)
            p.lost();
    }

    private void applyBonusCard(BonusCard card, Square s, Player p) {
        // TODO
    }

    public void endTurn() {
        game.endTurn();
    }

    public void build() throws Game.NotBuildableException {
        game.build();
        // TODO Update views
    }

    /**
     * Conditions:
     * 1. Current player has not rolled before
     *          OR
     * 2. Current player has rolled before and it was doubles
     */
    public boolean canRoll() {
        return !game.playerRolled() || (game.playerRolled() && game.playerHadDoubles());
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
