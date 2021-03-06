package controllers;

import controllers.dbmanagement.DatabaseHelper;
import gui.PlayerRegistrationSection;
import models.Game;
import models.Player;
import models.Rules;
import models.cards.BonusCard;
import models.cards.ChanceCard;
import models.cards.CommunityChestCard;
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
     * @throws PlayerRegistrationSection.TooFewPlayersException PRE: self.game == null
     *                                                          POST: self.game != null
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
        Player p = game.getCurrentPlayer();
        if (p.getBudget() <= 0)
            p.lost();
        checkIfGameEnded();
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
        helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        helpFrame.setSize(1152, 730);
        helpFrame.setContentPane(game.getHelp().getView().getContent(true));
        helpFrame.setVisible(true);
    }

    public void endGame() {

        if (game.hasFinished()) {
            Date today = new Date();
            DateFormat dayMonthYearFormat = new SimpleDateFormat("dd/MM/yyyy");
            new DatabaseHelper().insertHighScoreToDB(game.getWinner().getName(), game.getWinner().getTokenFigure().toString(), game.getWinner().getBudget(), dayMonthYearFormat.format(today));
            game.getView().closeWindow(true);
        } else {
            game.getView().closeWindow(false);
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
        else if (s.getPosition() == Rules.JAIL_POSITION) {
            p.setPosition(Rules.JAIL_POSITION);

            if (!p.useOutOfJail())
                p.setInJail(true);
        }

        if (s.getPosition() < p.getOldPosition() && !p.isInJail())
            p.updateBudget(Rules.SALARY);

        if (p.getBudget() <= 0)
            p.lost();


        checkIfGameEnded();
        game.notifyObservers();
    }

    private void checkIfGameEnded() {
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
    }

    private void applyBonusCard(BonusCard card, Square s, Player p) {

        // Amount
        if (card.getPayAmount() != 0) {
            p.updateBudget(card.getPayAmount());
        }

        // Jail
        if (card.isJailCard()) {
            p.setPosition(Rules.JAIL_POSITION);
            if (!p.useOutOfJail())
                p.setInJail(true);
        }

        // Out of Jail
        if (card.isOutOfJailCard()) {
            p.addOutOfJailCard();
        }

        if (card instanceof ChanceCard) {
            // Go To
            if (((ChanceCard) card).hasGoTo()) {
                Integer goTo = ((ChanceCard) card).getGoToDestination();
                if (goTo < 0)
                    p.updatePosition(goTo);
                else
                    p.setPosition(goTo);

                checkLandingSquare();
            }

            // Pay per house
            if (((ChanceCard) card).getPayPerHouseAmount() != 0) {
                p.payPerHouse(((ChanceCard) card).getPayPerHouseAmount());
            }

            // Pay per Hotel
            if (((ChanceCard) card).getPayPerHotelAmount() != 0) {
                p.payPerHotel(((ChanceCard) card).getPayPerHotelAmount());
            }

        } else if (card instanceof CommunityChestCard) {
            int amount = ((CommunityChestCard) card).getPayAmountForEachPlayer();
            if (amount != 0) {
                // Assign every player the negative of the amount
                for (Player player : game.getListOfPlayers()) {
                    player.updateBudget(-amount);
                }

                p.updateBudget(game.getListOfPlayers().size() * amount);
            }
        }

        game.getListOfPlayers().stream().filter(player -> player.getBudget() <= 0).forEach(Player::lost);
        checkIfGameEnded();
    }

    public void endTurn() {
        checkIfGameEnded();
        game.endTurn();
    }

    public void build() throws Game.NotBuildableException {
        game.build();
        Player p = game.getCurrentPlayer();
        if (p.getBudget() <= 0)
            p.lost();
        checkIfGameEnded();
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
                && game.getCurrentPlayer().getBudget() > ((PropertySquare) currentSquare).getCard().getSellPrice();
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
                && currentPlayer.getBudget() > ((TownSquare) currentSquare).getCard().getHouseBuildPrice()
                && !((TownSquare) currentSquare).isFull();
    }

    public String getWinnerName() {
        return game.getWinner().getName();
    }

    public void upgradeDice() throws Player.DiceCannotBeUpgradedException {
        game.upgradeDice();
    }

    public void upgradeToken() throws Player.TokenCannotBeUpgradedException {
        game.upgradeToken();
    }
}
