package gui;

import models.Player;
import models.cards.PropertyCard;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author anikristo
 */
public class SidePanel {

    // ATTRIBUTES
    private JPanel mainPn;
    private JPanel playersPn;
    private JButton upgradeTokenBtn;
    private JButton upgradeDiceBtn;
    private JButton helpBtn;
    private JButton exitGameButton;
    private JPanel propertyCardsPn;

    // CONSTRUCTOR
    public SidePanel(List<Player> listOfPlayers, List<PropertyCard> propertyCards) {

        playersPn.setLayout(new BoxLayout(playersPn, BoxLayout.Y_AXIS));
        for (int i = 1; i < listOfPlayers.size() + 1; i++)
            playersPn.add(new PlayerView(i, listOfPlayers.get(i - 1)).getContent());

        // Setting up the matrix of the property cards
        propertyCardsPn.setLayout(new GridLayout(7, 4));
        for (PropertyCard propertyCard : propertyCards) {
            propertyCardsPn.add(new PropertyCardSmallView(propertyCard).getContent());
        }

        helpBtn.addActionListener(actionEvent ->  /*TODO*/);
        exitGameButton.addActionListener(actionEvent ->  /*TODO*/);
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
}
