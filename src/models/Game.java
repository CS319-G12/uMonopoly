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
 * @invariant self.turn >= 0 && self.turn < 4
 * @invariant self.currentSquares.size() == 4
 * @invariant self.players.size() > 1 && self.players.size() <= 4
 * @invariant self.playerNames.size() > 1 && self.playerNames.size() <= 4
 * @invariant self.players.size() == self.playerNames.size()
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

        for (Map.Entry<String, TokenFigure> entry : playerDetails.entrySet())
            addPlayer(entry.getKey(), entry.getValue());

        this.view = new GameScreen(this);
    }

    // METHODS

    /**
     * This method adds a new player to the game
     *
     * @param name        the name of the player to be added as received from the GUI
     * @param tokenFigure the token figure selected from the player at registration
     * @pre !playerNames->includes(name)
     * @post self.players.size() == self@pre.players.size() + 1
     * @post self.playerNames.size() == self@pre.playerNames.size() + 1
     */
    private void addPlayer(String name, TokenFigure tokenFigure) {
        Player newPlayer = new Player(name, tokenFigure);
        players.add(newPlayer);
        playerNames.add(name);

        notifyObservers();
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    /**
     * @param name The name of the player to be removed
     * @throws PlayerNotFoundException
     * @pre self.players.size() > 0
     * @pre self.playerNames->includes(name)
     * @post self.players.size() == self@pre.players.size() - 1
     * @post self.playerNames.size() == self@pre.playerNames.size() - 1
     */
    public void removePlayer(String name) {
        players.remove(playerNames.indexOf(name));
        playerNames.remove(playerNames.indexOf(name));
    } // TODO for losing

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
        // TODO
        Square currentSquare = getCurrentSquare();
        if (!(currentSquare instanceof PropertySquare))
            throw new NotBuyableException();

        PropertySquare square = (PropertySquare) currentSquare;
        if (square.getCard().getOwner() == null && getCurrentPlayer().getBudget() >= square.getCard().getSellPrice()) {
            square.setOwner(getCurrentPlayer());
            getCurrentPlayer().addPropertyCard(square.getCard());
            getCurrentPlayer().updateBudget((-1) * square.getCard().getSellPrice());
        }

        setChanged();
        notifyObservers();
    }

    public void sellProperty() throws NotSellableException {
        // todo
        Square currentSquare = getCurrentSquare();
        if (!(currentSquare instanceof PropertySquare))
            throw new NotSellableException();

        PropertySquare square = (PropertySquare) currentSquare;
        if (square.getCard().getOwner() != null) {
            getCurrentPlayer().updateBudget(square.getCard().getMortgagePrice());
            getCurrentPlayer().removePropertyCard(square.getCard());
            square.removeOwner();
            if (square instanceof TownSquare)
                ((TownSquare) square).removebuildings();
        }

        setChanged();
        notifyObservers();
    }

    public void build() throws NotBuildableException {
        Square currentSquare = getCurrentSquare();
        if (!(currentSquare instanceof PropertySquare))
            throw new NotBuildableException();

        PropertySquare square = (PropertySquare) currentSquare;
        if (square.getGroup().ownsAllProperties(getCurrentPlayer()) && getCurrentPlayer().getBudget() >= ((TownSquare) square).getCard().getHouseBuildPrice()) {
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
        playerHadDoubles = getCurrentPlayer().roll();
        playerRolled = true;
        updateCurrentSquares();
        setChanged();
    }

    public void endTurn() {
        // TODO update views of the current square and list of property cards owned
        // TODo make player had doubles false
        incrementTurn();
        playerRolled = false;
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
