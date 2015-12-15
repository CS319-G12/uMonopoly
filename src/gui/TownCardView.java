package gui;

import models.cards.TownCard;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * @author Ani Kristo
 */
public class TownCardView {

    // ATTRIBUTES
    private JPanel mainPanel;
    private JPanel titlePn;
    private JLabel firstRentLb;
    private JPanel rentPn;
    private JLabel titleLb;
    private JLabel oneHouseLb;
    private JLabel twoHousesLb;
    private JLabel oneHouseRentLb;
    private JLabel twoHousesRentLb;
    private JLabel threeHousesLb;
    private JLabel threeHousesRentLb;
    private JLabel fourHousesLb;
    private JLabel fourHousesRentLb;
    private JLabel hotelLb;
    private JLabel hotelRentLb;
    private JLabel mortgageValueLb;
    private JLabel houseCostLb;
    private JLabel hotelCostLb;

    // CONSTRUCTOR
    public TownCardView(TownCard card) {

        // Fixing form design
        titlePn.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, java.awt.Color.BLACK));
        Border border1 = BorderFactory.createMatteBorder(1, 1, 1, 1, java.awt.Color.BLACK);
        Border border2 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        rentPn.setBorder(BorderFactory.createCompoundBorder(border1, border2));

        // Setting up the card view
        titlePn.setBackground(card.getColor().awtColor());
        titleLb.setText(card.getName());
        firstRentLb.setText("RENT " + card.getRentPrice(0) + "$");
        oneHouseRentLb.setText(card.getRentPrice(1) + "$");
        twoHousesRentLb.setText(card.getRentPrice(2) + "$");
        threeHousesRentLb.setText(card.getRentPrice(3) + "$");
        fourHousesRentLb.setText(card.getRentPrice(4) + "$");
        hotelRentLb.setText(card.getHotelRentPrice() + "$");
        mortgageValueLb.setText("Mortgage value " + card.getMortgagePrice() + "$");
        houseCostLb.setText("Houses cost " + card.getHouseBuildPrice() + "$ each");
        hotelCostLb.setText("<html><center>Hotels cost " + card.getHotelBuildPrice() + "$ each<br>plus 4 houses</html>");

        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    }

    // METHODS
    public JPanel getContent() {
        return mainPanel;
    }
}
