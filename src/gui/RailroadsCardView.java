package gui;

import models.cards.RailroadsCard;

import javax.swing.*;

/**
 * @author Ani Kristo
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
        rentValueLb.setText(card.getRentPrice(1) + "$");
        twoStationsRentLb.setText(card.getRentPrice(2) + "$");
        threeStationsRentLb.setText(card.getRentPrice(3) + "$");
        fourStationsRentLb.setText(card.getRentPrice(4) + "$");
        mortgageValueLb.setText("Mortgage value " + card.getMortgagePrice() + "$");

    }

    // METHODS
    public JPanel getContent() {
        return mainPanel;
    }
}
