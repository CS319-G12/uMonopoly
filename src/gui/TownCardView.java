package gui;

import domain.cards.TownCard;

import javax.swing.*;

/**
 * @author anikristo
 */
public class TownCardView { // TODO test

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
        titlePn.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        rentPn.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        // Setting up the card view
        titlePn.setBackground(card.getColor());
        titleLb.setText(card.getName());
        firstRentLb.setText("RENT " + card.getRent(0) + "$");
        oneHouseRentLb.setText(card.getRent(1) + "$");
        twoHousesRentLb.setText(card.getRent(2) + "$");
        threeHousesRentLb.setText(card.getRent(3) + "$");
        fourHousesRentLb.setText(card.getRent(4) + "$");
        hotelRentLb.setText(card.getRent(5) + "$");
        mortgageValueLb.setText("Mortgage value " + card.getMortagePrice() + "$");
        houseCostLb.setText("Houses cost " + card.getHousePrice() + "$ each");
        hotelCostLb.setText("<html><center>Hotels cost " + card.getHotelPrice() + "$ each<br>plus 4 houses</html>");

    }

    // METHODS
    JPanel getContent() {
        return mainPanel;
    }
}
