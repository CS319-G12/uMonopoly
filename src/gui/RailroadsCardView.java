package gui;

import domain.cards.RailroadsCard;

import javax.swing.*;

/**
 * @author anikristo
 */
public class RailroadsCardView {

    // ATTRIBUTES
    private JPanel mainPanel;
    private JLabel titleLb;
    private JLabel rentValueLb;
    private JLabel twoStationsRentLb;
    private JLabel threeStationsRentLb;
    private JLabel fourStationsRentLb;
    private JLabel mortgageValueLb;

    // CONSTRUCTOR
    public RailroadsCardView(RailroadsCard card) {

        // Setting up the card view
        titleLb.setText(card.getName());
        rentValueLb.setText(card.getRent(1) + "$");
        twoStationsRentLb.setText(card.getRent(2) + "$");
        threeStationsRentLb.setText(card.getRent(3) + "$");
        fourStationsRentLb.setText(card.getRent(4) + "$");
        mortgageValueLb.setText("Mortgage value " + card.getMortagePrice() + "$");

    }

    // METHODS
    JPanel getContent() {
        return mainPanel;
    }
}
