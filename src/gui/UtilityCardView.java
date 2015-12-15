package gui;

import models.Rules;
import models.cards.UtilityCard;

import javax.swing.*;

/**
 * @author Ani Kristo
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
        oneUtilityLb.setText("<html><center><div style=\"width:100px;\">If one Utility is owned, the rent is " + card.getRentPrice(1) + " times amount " +
                "shown on the dice.</div></center></html>");
        twoUtilitiesLb.setText("<html><center><div style=\"width:100px;\">If both Utilities are owned, the rent is " + card.getRentPrice(2) + " times amount " +
                "shown on the dice.</div></center></html>");
        mortgageValueLb.setText("Mortgage value " + card.getMortgagePrice() + "$");

        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    }

    // METHODS
    public JPanel getContent() {
        return mainPanel;
    }
}
