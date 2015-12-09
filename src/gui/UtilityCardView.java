package gui;

import models.Rules;
import models.cards.UtilityCard;

import javax.swing.*;

/**
 * @author anikristo
 */
public class UtilityCardView {

    // ATTRIBUTES
    private JLabel pictureLb;
    private JLabel oneUtilityLb;
    private JLabel twoUtilitiesLb;
    private JLabel mortgageValueLb;
    private JLabel titleLb;
    private JPanel mainPanel;

    // CONSTRUCTOR
    public UtilityCardView(UtilityCard card) {

        // Setting up the card view
        if (card.getName().equals(Rules.Utilities.ELECTRIC_COMPANY))
            pictureLb.setIcon(new ImageIcon(getClass().getResource("/img/electric_company.png")));
        else if (card.getName().equals(Rules.Utilities.WATER_WORKS))
            pictureLb.setIcon(new ImageIcon(getClass().getResource("/img/water_works.png")));
        titleLb.setText(card.getName());
        oneUtilityLb.setText("If one Utility is owned, the rent is " + card.getRentPrice(1) + " times amount" +
                "shown on the dice.");
        twoUtilitiesLb.setText("If both Utilities are owned, the rent is " + card.getRentPrice(2) + " times amount" +
                "shown on the dice.");
        mortgageValueLb.setText("Mortgage value " + card.getMortgagePrice() + "$");

    }

    // METHODS
    JPanel getContent() {
        return mainPanel;
    }
}
