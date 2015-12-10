package models;

import controllers.GameController;
import controllers.HelpController;
import gui.GameScreen;
import gui.PlayerRegistrationSection;
import models.cards.PropertyCard;
import models.help.Help;
import models.squares.PropertySquare;
import models.squares.Square;
import models.token.TokenFigure;

import java.util.ArrayList;
import java.util.List;
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
    public Game(GameController controller, HelpController helpController) {
        hasFinished = false;
        players = new ArrayList<>(Rules.MAX_PLAYERS);
        playerNames = new ArrayList<>(Rules.MAX_PLAYERS);
        this.controller = controller;
        this.helpController = helpController;
        this.view = new GameScreen(this);
    }

    // METHODS

    /**
     * This method adds a new player to the game
     *
     * @param name        the name of the player to be added as received from the GUI
     * @param tokenFigure the token figure selected from the player at registration
     * @throws PlayerRegistrationSection.NameNotUniqueException
     * @pre !playerNames->includes(name)
     * @post self.players.size() == self@pre.players.size() + 1
     * @post self.playerNames.size() == self@pre.playerNames.size() + 1
     */
    public void addPlayer(String name, TokenFigure tokenFigure) throws PlayerRegistrationSection.NameNotUniqueException {
        Player newPlayer = new Player(name, tokenFigure);
        if (playerNames.contains(name))
            throw new PlayerRegistrationSection.NameNotUniqueException();
        else {
            players.add(newPlayer);
            playerNames.add(name);
        }
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
//        one.setText("MEDITERRANEAN\nAVENUE");
//        one.setBackground(Color.BROWN.awtColor());
//
//        two.setText("BALTIC\nAVENUE");
//        two.setBackground(Color.BROWN.awtColor());
//
//        three.setText("ORIENTAL\nAVENUE");
//        three.setBackground(Color.LIGHT_BLUE.awtColor());
//
//        four.setText("VERMONT\nAVENUE");
//        four.setBackground(Color.LIGHT_BLUE.awtColor());
//
//        five.setText("CONNECTICUT\nAVENUE");
//        five.setBackground(Color.LIGHT_BLUE.awtColor());
//
//        six.setText("ST CHARLES\nPLACE");
//        six.setBackground(Color.PINK.awtColor());
//
//        seven.setText("STATES\nAVENUE");
//        seven.setBackground(Color.PINK.awtColor());
//
//        eight.setText("VIRGINIA\nAVENUE");
//        eight.setBackground(Color.PINK.awtColor());
//
//        nine.setText("ST JAMES\nPLACE");
//        nine.setBackground(Color.ORANGE.awtColor());
//
//        ten.setText("TENNESSEE\nAVENUE");
//        ten.setBackground(Color.ORANGE.awtColor());
//
//        eleven.setText("NEW YORK\nAVENUE");
//        eleven.setBackground(Color.ORANGE.awtColor());
//
//        twelve.setText("KENTUCKY\nAVENUE");
//        twelve.setBackground(Color.RED.awtColor());
//
//        thirteen.setText("INDIANA\nAVENUE");
//        thirteen.setBackground(Color.RED.awtColor());
//
//        fourteen.setText("ILLINOIS\nAVENUE");
//        fourteen.setBackground(Color.RED.awtColor());
//
//        fifteen.setText("ATLANTIC\nAVENUE");
//        fifteen.setBackground(Color.YELLOW.awtColor());
//
//        sixteen.setText("VENTNOR\nAVENUE");
//        sixteen.setBackground(Color.YELLOW.awtColor());
//
//        seventeen.setText("MARVIN\nGARDENS");
//        seventeen.setBackground(Color.YELLOW.awtColor());
//
//        eighteen.setText("PACIFIC\nAVENUE");
//        eighteen.setBackground(Color.GREEN.awtColor());
//
//        nineteen.setText("CAROLINA\nAVENUE");
//        nineteen.setBackground(Color.GREEN.awtColor());
//
//        twenty.setText("PENNSYLVANIA\nAVENUE");
//        twenty.setBackground(Color.GREEN.awtColor());
//
//        twentyone.setText("PARK\nPLACE");
//        twentyone.setBackground(Color.BLUE.awtColor());
//
//        twentytwo.setText("BROADWALK");
//        twentytwo.setBackground(Color.BLUE.awtColor());
//
//        twentythree.setText("ELECTRIC\nCOMPANY");
//        twentythree.setBackground(Color.CHARCOAL.awtColor());
//
//        twentyfour.setText("WATER\nWORKS");
//        twentyfour.setBackground(Color.CHARCOAL.awtColor());
//
//        twentyfive.setText("READING\nRAILROAD");
//        twentyfive.setBackground(Color.CHARCOAL.awtColor());
//
//        twentysix.setText("PENNSYLVANIA\nRAILROAD");
//        twentysix.setBackground(Color.CHARCOAL.awtColor());
//
//        twentyseven.setText("B. & o.\nRAILROAD");
//        twentyseven.setBackground(Color.CHARCOAL.awtColor());
//
//        twentyeight.setText("SHORT\nLINE");
//        twentyeight.setBackground(Color.CHARCOAL.awtColor());
//

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
                        .map(s -> ((PropertySquare) s).getPropertyCard())
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

    public static class PlayerNotFoundException extends Exception {
        @Override
        public String getMessage() {
            return super.getMessage() + "The player is not registered in the game!";
        }
    }
}
