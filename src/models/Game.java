package models;

import controllers.GameController;
import controllers.HelpController;
import gui.GameScreen;
import models.cards.PropertyCard;
import models.dice.DiceValue;
import models.help.Help;
import models.squares.PropertySquare;
import models.squares.Square;
import models.token.TokenFigure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.stream.Collectors;

/**
 * @author anikristo
 * @invariant self.turn >= 0 && self.turn < 4
 * @invariant self.currentSquares.size() == 4
 * @invariant self.players.size() > 1 && self.players.size() <= 4
 * @invariant self.playerNames.size() > 1 && self.playerNames.size() <= 4
 * @invariant self.players.size() == self.playerNames.size()
 */
public class Game extends Observable {

    // ATTRIBUTES
    private int turn;
    private List<Square> currentSquares;
    private boolean hasFinished;
    private MonopolyBoard board;
    private List<Player> players;
    private List<String> playerNames;

    private GameController controller;
    private GameScreen view;

    private HelpController helpController;

    // CONSTRUCTOR
    public Game(GameController controller, HelpController helpController, Map<String, TokenFigure> playerDetails) {
        hasFinished = false;
        this.players = new ArrayList<>(Rules.MAX_PLAYERS);
        playerNames = new ArrayList<>(Rules.MAX_PLAYERS);
        this.controller = controller;
        this.helpController = helpController;
        this.board = new MonopolyBoard();

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
    public void addPlayer(String name, TokenFigure tokenFigure) {
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
    public void removePlayer(String name) throws PlayerNotFoundException {
        players.remove(playerNames.indexOf(name));
        playerNames.remove(playerNames.indexOf(name));
    }

    public void start() {

        // TODO create cards and squares using AF
        hasFinished = false;
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
        return currentSquares.get(turn);
    }

    public DiceValue getDiceValue1() {
        return players.get(turn).getDiceValue1();
    }

    public DiceValue getDiceValue2() {
        return players.get(turn).getDiceValue2();
    }

    public static class PlayerNotFoundException extends Exception {
        @Override
        public String getMessage() {
            return super.getMessage() + "The player is not registered in the game!";
        }
    }
}
