package models;

import controllers.GameController;
import controllers.HelpController;
import gui.GameScreen;
import models.cards.PropertyCard;
import models.dice.DiceValue;
import models.help.Help;
import models.squares.PropertySquare;
import models.squares.Square;
import models.squares.TownSquare;
import models.token.TokenFigure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.stream.Collectors;

/**
 * @author Ani Kristo & Alper Önder
 * INV: self.turn >= 0 && self.turn < 4
 * INV: self.currentSquares.size() == 4
 * INV: self.players.size() > 1 && self.players.size() <= 4
 * INV: self.playerNames.size() > 1 && self.playerNames.size() <= 4
 * INV: self.players.size() == self.playerNames.size()
 */
public class Game extends Observable {

    // ATTRIBUTES
    private int turn;
    private List<Integer> currentSquares;
    private boolean hasFinished;
    private MonopolyBoard board;
    private List<Player> players;
    private List<String> playerNames;

    private GameController controller;
    private GameScreen view;

    private HelpController helpController;

    private boolean playerRolled;
    private boolean playerHadDoubles;
    private int numberOfDoubles;

    // CONSTRUCTOR
    public Game(GameController controller, HelpController helpController, Map<String, TokenFigure> playerDetails) {
        hasFinished = false;
        this.players = new ArrayList<>(Rules.MAX_PLAYERS);
        playerNames = new ArrayList<>(Rules.MAX_PLAYERS);
        this.controller = controller;
        this.helpController = helpController;
        this.board = new MonopolyBoard();
        playerRolled = false;
        playerHadDoubles = false;
        numberOfDoubles = 0;

        for (Map.Entry<String, TokenFigure> entry : playerDetails.entrySet())
            addPlayer(entry.getKey(), entry.getValue());
        players.get(0).setPlaying(true);

        this.view = new GameScreen(this);
    }

    // METHODS

    /**
     * This method adds a new player to the game
     *
     * @param name        the name of the player to be added as received from the GUI
     * @param tokenFigure the token figure selected from the player at registration
     * PRE: !playerNames->includes(name)
     * POST: self.players.size() == selfPRE:.players.size() + 1
     * POST: self.playerNames.size() == selfPRE:.playerNames.size() + 1
     */
    private void addPlayer(String name, TokenFigure tokenFigure) {
        Player newPlayer = new Player(name, tokenFigure);
        players.add(newPlayer);
        playerNames.add(name);

        notifyObservers();
    }

    public void start() {
        turn = 0;
        hasFinished = false;
        for (Player p : players)
            p.setPosition(Rules.GO_POSITION);
        currentSquares = new ArrayList<>();
        for (int i = 0; i < players.size(); i++)
            currentSquares.add(Rules.GO_POSITION);

        Square square = getListOfSquares().get(Rules.GO_POSITION);
        players.forEach(square::addResidingPlayer);

        notifyObservers();
    }

    private void updateCurrentSquares() {

        List<Square> listOfSquares = getListOfSquares();

        // Remove the old tokens
        for (Integer i : currentSquares) {
            listOfSquares.get(i).clearResidingPlayers();
        }

        for (int i = 0; i < players.size(); i++) {

            int position = players.get(i).getPosition();

            // Update Current Squares
            currentSquares.set(i, position);

            // Update Residing Players
            listOfSquares.get(position).addResidingPlayer(players.get(i));
        }
        notifyObservers();
    }

    public List<Square> getListOfSquares() {
        return board.getListOfSquares();
    }

    public List<Player> getListOfPlayers() {
        return players;
    }

    public List<PropertyCard> getListOfPropertyCards() {
        List<Square> squares = getListOfSquares();
        List<PropertyCard> propertyCardList = new ArrayList<>(squares.size());

        propertyCardList
                .addAll(squares.stream()
                        .filter(s -> s instanceof PropertySquare)
                        .map(s -> ((PropertySquare) s).getCard())
                        .collect(Collectors.toList()));

        return propertyCardList;
    }

    public GameController getController() {
        return controller;
    }

    public Player getCurrentPlayer() {
        return players.get(turn);
    }

    public Help getHelp() {
        return helpController.getHelp();
    }

    public GameScreen getView() {
        return view;
    }

    public boolean hasFinished() {
        return hasFinished;
    }

    public void finished() {
        this.hasFinished = true;
        notifyObservers(); // TODO dialog with winner and disable all buttons and display
    }

    public Square getCurrentSquare() {
        return board.getListOfSquares().get(currentSquares.get(turn));
    }

    public DiceValue getDiceValue1() {
        return getCurrentPlayer().getDiceValue1();
    }

    public DiceValue getDiceValue2() {
        return getCurrentPlayer().getDiceValue2();
    }

    public void buyProperty() throws NotBuyableException {
        Square currentSquare = getCurrentSquare();
        if (!(currentSquare instanceof PropertySquare))
            throw new NotBuyableException();

        PropertySquare square = (PropertySquare) currentSquare;
        if (square.getCard().getOwner() == null && getCurrentPlayer().getBudget() > square.getCard().getSellPrice()) {
            square.setOwner(getCurrentPlayer());
            getCurrentPlayer().addPropertyCard(square.getCard());
            getCurrentPlayer().updateBudget((-1) * square.getCard().getSellPrice());
        }

        setChanged();
        notifyObservers();
    }

    public void sellProperty() throws NotSellableException {
        Square currentSquare = getCurrentSquare();
        if (!(currentSquare instanceof PropertySquare))
            throw new NotSellableException();

        PropertySquare square = (PropertySquare) currentSquare;
        if (square.getCard().getOwner() != null) {
            getCurrentPlayer().updateBudget(square.getCard().getMortgagePrice());
            getCurrentPlayer().removePropertyCard(square.getCard());
            square.removeOwner();
            if (square instanceof TownSquare)
                ((TownSquare) square).removeBuildings();
        }

        setChanged();
        notifyObservers();
    }

    public void build() throws NotBuildableException {
        Square currentSquare = getCurrentSquare();
        if (!(currentSquare instanceof PropertySquare))
            throw new NotBuildableException();

        PropertySquare square = (PropertySquare) currentSquare;
        if (square.getGroup().ownsAllProperties(getCurrentPlayer()) && getCurrentPlayer().getBudget() > ((TownSquare) square).getCard().getHouseBuildPrice()) {
            try {
                ((TownSquare) square).build();
                getCurrentPlayer().updateBudget((-1) * ((TownSquare) square).getCard().getHouseBuildPrice());
            } catch (TownSquare.CannotBuildException e) {
                System.err.println(e.getMessage());
            }
        }

        setChanged();
        notifyObservers();
    }

    public boolean playerRolled() {
        return playerRolled;
    }

    public void roll() {
        Player p = getCurrentPlayer();
        playerHadDoubles = p.roll();

        if (p.isInJail() && !playerHadDoubles) { // not doubles
            playerRolled = true;
            updateCurrentSquares();
            p.incrementJailTurns();
            updateCurrentSquares();
            endTurn();
            return;
        }

        if (playerHadDoubles)
            numberOfDoubles++;

        if (numberOfDoubles == 3) {
            p.setInJail(true);
            playerRolled = true;
            updateCurrentSquares();
            endTurn();
            return;
        }

        playerRolled = true;
        updateCurrentSquares();
        setChanged();
    }

    public void endTurn() {
        incrementTurn();
        playerRolled = false;
        numberOfDoubles = 0;
        setChanged();
        notifyObservers();
    }

    private void incrementTurn() {
        players.get(turn).setPlaying(false);
        turn++;
        if (turn == players.size())
            turn = 0;

        if (players.get(turn).hasLost())
            incrementTurn();

        players.get(turn).setPlaying(true);
    }

    public Player getWinner() {
        int id = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getBudget() > players.get(id).getBudget())
                id = i;
        }
        return players.get(id);
      /*  Collections.max(players, (o1, o2) -> {
            if(o1.getBudget() > o2.getBudget())
                return 1;
            else  if(o1.getBudget() < o2.getBudget())
                return -1;
            else
                return 0;
        }); */
    }

    public boolean playerHadDoubles() {
        return playerHadDoubles;
    }

    private static class PlayerNotFoundException extends Exception {
        @Override
        public String getMessage() {
            return super.getMessage() + "The player is not registered in the game!";
        }
    }

    public static class NotSellableException extends Exception {
        @Override
        public String getMessage() {
            return super.getMessage() + "The Player cannot sell the property.";
        }

    }

    public static class NotBuyableException extends Exception {
        @Override
        public String getMessage() {
            return super.getMessage() + "The player cannot buy the property.";
        }
    }

    public static class NotBuildableException extends Exception {
        @Override
        public String getMessage() {
            return super.getMessage() + "The player cannot build house in this square.";
        }
    }
}
