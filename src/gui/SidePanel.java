package gui;

import controllers.GameController;
import models.Game;
import models.Player;
import models.Rules;
import models.cards.PropertyCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

/**
 * @author Ani Kristo
 */
class SidePanel implements Observer {

    // ATTRIBUTES
    private JPanel mainPn;
    private JPanel playersPn;
    private JButton upgradeTokenBtn;
    private JButton upgradeDiceBtn;
    private JButton helpBtn;
    private JButton exitGameButton;
    private JPanel propertyCardsPn;

    private GameController gameController;
    private List<PlayerView> playerViewList;
    private List<PropertyCardSmallView> listOfPropertyCardSmallViews;

    // CONSTRUCTOR
    public SidePanel(Game game) {

        game.addObserver(this);

        this.gameController = game.getController();
        List<Player> listOfPlayers = game.getListOfPlayers();
        List<PropertyCard> listOfPropertyCards = game.getListOfPropertyCards();

        this.playerViewList = new ArrayList<>(Rules.MAX_PLAYERS);
        playersPn.setLayout(new BoxLayout(playersPn, BoxLayout.Y_AXIS));
        for (int i = 1; i < listOfPlayers.size() + 1; i++) {
            PlayerView pv = new PlayerView(i, listOfPlayers.get(i - 1));
            playersPn.add(pv.getContent());
            playerViewList.add(pv);
        }

        // Setting up the matrix of the property cards
        listOfPropertyCardSmallViews = new ArrayList<>();
        propertyCardsPn.setLayout(new GridLayout(7, 4));
        for (PropertyCard propertyCard : listOfPropertyCards) {
            PropertyCardSmallView pcsv = new PropertyCardSmallView(propertyCard);
            listOfPropertyCardSmallViews.add(pcsv);
            propertyCardsPn.add(pcsv.getContent());
        }

        helpBtn.addActionListener(actionEvent -> gameController.viewHelp());
        exitGameButton.addActionListener(actionEvent -> gameController.endGame());
    }

    // METHODS
    public JPanel getContent() {
        return mainPn;
    }

    private void setTokenButtonsPrice(int price) {
        this.upgradeTokenBtn.setText(String.format("Upgrade Token\n(%d$)", price));
    }

    private void setdiceButtonsPrice(int price) {
        this.upgradeDiceBtn.setText(String.format("Upgrade Dice\n(%d$)", price));
    }

    @Override
    public void update(Observable observable, Object o) {

        if (observable instanceof Game) {

            // Update the player's budgets
            List<Player> players = ((Game) observable).getListOfPlayers();
            for (int i = 0; i < players.size(); i++) {
                playerViewList.get(i).update(players.get(i), null);
            }

            // Update (enable / disable) the properties they own
            List<Integer> propertyCardsIndices =
                    ((Game) observable).getCurrentPlayer().getListOfPropertyCards()
                            .stream()
                            .map(PropertyCard::getID)
                            .collect(Collectors.toList());
            for (int i = 0; i < listOfPropertyCardSmallViews.size(); i++) {
                if (propertyCardsIndices.contains(i))
                    listOfPropertyCardSmallViews.get(i).setEnabled(true);
                else
                    listOfPropertyCardSmallViews.get(i).setEnabled(false);
            }

        }
    }
}
