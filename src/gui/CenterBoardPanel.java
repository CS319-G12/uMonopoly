package gui;

import controllers.GameController;
import models.Game;
import models.squares.*;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Ani Kristo
 */
class CenterBoardPanel implements Observer {

    // ATTRIBUTES
    private final ImageIcon houseIcon;
    private final ImageIcon hotelIcon;
    private final GameController controller;

    private JPanel mainPn;
    private JButton rollBtn;
    private JButton endBtn;
    private JLabel diceV1;
    private JLabel diceV2;
    private JButton buyBtn;
    private JButton sellBtn;
    private JButton buildBtn;
    private JLabel buildingCountLb;
    private JLabel buildingIconLb;
    private JPanel cardDisplayPn;
    private JPanel buildingPn;

    // CONSTRUCTOR
    public CenterBoardPanel(Game game) {
        game.addObserver(this);
        this.controller = game.getController();

        // Adding action listeners
        rollBtn.addActionListener(actionEvent -> {
            controller.roll();

            // Update the dice views
            diceV1.setIcon(controller.getGame().getDiceValue1().getIcon());
            diceV2.setIcon(controller.getGame().getDiceValue2().getIcon());
            updateButtons();
        });
        endBtn.addActionListener(actionEvent -> {
            controller.endTurn();
            updateButtons();
        });
        buyBtn.addActionListener(actionEvent -> {
            try {
                controller.buyProperty();
            } catch (Game.NotBuyableException e) {
                // TODO
            } finally {
                buyBtn.setEnabled(false);
                updateButtons();
            }
        });
        sellBtn.addActionListener(actionEvent -> {
            try {
                controller.sellProperty();
            } catch (Game.NotSellableException e) {
            } finally {
                sellBtn.setEnabled(false);
                updateButtons();
            }
        });
        buildBtn.addActionListener(actionEvent -> {
            try {
                controller.build();
            } catch (Game.NotBuildableException e) {
                buildBtn.setEnabled(false);
            } finally {
                updateButtons();
            }
        });

        // Disabling the buttons since the game starts at GO square
        buyBtn.setEnabled(false);
        sellBtn.setEnabled(false);
        buildBtn.setEnabled(false);
        endBtn.setEnabled(false);

        this.houseIcon = new ImageIcon(getClass().getResource("/img/house_big.png"));
        this.hotelIcon = new ImageIcon(getClass().getResource("/img/hotel_big.png"));

        buildingPn.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
    }

    private void updateButtons() {
        // Roll Button
        if (controller.canRoll())
            rollBtn.setEnabled(true);
        else
            rollBtn.setEnabled(false);

        // End Turn Button
        if (controller.canEndTurn())
            endBtn.setEnabled(true);
        else
            endBtn.setEnabled(false);

        // Buy Button
        if (controller.canBuy())
            buyBtn.setEnabled(true);
        else
            buyBtn.setEnabled(false);

        // Sell Button
        if (controller.canSell())
            sellBtn.setEnabled(true);
        else
            sellBtn.setEnabled(false);

        // Build Button
        if (controller.canBuild())
            buildBtn.setEnabled(true);
        else
            buildBtn.setEnabled(false);
    }

    // METHODS
    public JPanel getContent() {
        return mainPn;
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof Game) {

            Game game = (Game) observable;

            // Update the card view
            Square currentSquare = game.getCurrentSquare();

            if (currentSquare instanceof PropertySquare) {
                cardDisplayPn.setMinimumSize(new Dimension(200, 318));
                cardDisplayPn.setMaximumSize(new Dimension(200, 318));
                cardDisplayPn.setPreferredSize(new Dimension(200, 318));
                cardDisplayPn.removeAll();
                cardDisplayPn.add(((PropertySquare) currentSquare).getCard().getView());
                mainPn.repaint();
            } else if (currentSquare instanceof ChanceCardSquare) {
                cardDisplayPn.setMinimumSize(new Dimension(318, 200));
                cardDisplayPn.setMaximumSize(new Dimension(318, 200));
                cardDisplayPn.setPreferredSize(new Dimension(318, 200));
                cardDisplayPn.removeAll();
                cardDisplayPn.add(((ChanceCardSquare) currentSquare).getCard().getView());
                mainPn.repaint();
            } else if (currentSquare instanceof CommunityChestCardSquare) {
                cardDisplayPn.setMinimumSize(new Dimension(318, 200));
                cardDisplayPn.setMaximumSize(new Dimension(318, 200));
                cardDisplayPn.setPreferredSize(new Dimension(318, 200));
                cardDisplayPn.removeAll();
                cardDisplayPn.add(((CommunityChestCardSquare) currentSquare).getCard().getView());
                mainPn.repaint();
            } else {
                cardDisplayPn.removeAll();
            }

            buildingCountLb.setVisible(false);
            buildingIconLb.setVisible(false);

            // Building count view
            if (currentSquare instanceof TownSquare) {
                buildingCountLb.setVisible(true);
                buildingIconLb.setVisible(true);
                buildingCountLb.setText(((TownSquare) currentSquare).getBuildingCount() + "");
                buildingIconLb.setIcon(((TownSquare) currentSquare).hasHotel() ? hotelIcon : houseIcon);
            }
            updateButtons();
        }
    }
}
