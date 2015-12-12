package gui;

import controllers.GameController;
import models.Game;
import models.squares.*;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author anikristo
 */
public class CenterBoardPanel implements Observer {

    // ATTRIBUTES
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

    private ImageIcon houseIcon;
    private ImageIcon hotelIcon;

    private GameController controller;

    // CONSTRUCTOR
    public CenterBoardPanel(Game model) {
        model.addObserver(this);
        this.controller = model.getController();

        // Adding action listeners
        rollBtn.addActionListener(actionEvent -> controller.roll());
        endBtn.addActionListener(actionEvent -> controller.endTurn());
        buyBtn.addActionListener(actionEvent -> controller.buyProperty());
        sellBtn.addActionListener(actionEvent -> controller.sellProperty());
        buildBtn.addActionListener(actionEvent -> controller.build());

        this.houseIcon = new ImageIcon(getClass().getResource("/img/house_big.png"));
        this.hotelIcon = new ImageIcon(getClass().getResource("/img/hotel_big.png"));
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

            if (currentSquare instanceof TownSquare)
                cardDisplayPn = ((TownSquare) currentSquare).getCard().getView().getContent();

            else if (currentSquare instanceof UtilitySquare)
                cardDisplayPn = ((UtilitySquare) currentSquare).getCard().getView().getContent();

            else if (currentSquare instanceof RailroadsSquare)
                cardDisplayPn = ((RailroadsSquare) currentSquare).getCard().getView().getContent();

            else if (currentSquare instanceof ChanceCardSquare)
                cardDisplayPn = ((ChanceCardSquare) currentSquare).getCard().getView().getContent();

            else if (currentSquare instanceof CommunityChestCardSquare)
                cardDisplayPn = ((CommunityChestCardSquare) currentSquare).getCard().getView().getContent();

            if (currentSquare instanceof TownSquare) {
                buildingCountLb.setText(((TownSquare) currentSquare).getBuildingCount() + "");
                buildingIconLb.setIcon(((TownSquare) currentSquare).hasHotel() ? hotelIcon : houseIcon);
            }


            // Update the dice views
            diceV1.setIcon(game.getDiceValue1().getIcon());
            diceV2.setIcon(game.getDiceValue2().getIcon());
        }
    }
}
