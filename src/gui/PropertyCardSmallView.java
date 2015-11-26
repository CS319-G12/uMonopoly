package gui;

import domain.cards.PropertyCard;

import javax.swing.*;

/**
 * @author anikristo
 */
public class PropertyCardSmallView { // TODO test

    // ATTRIBUTES
    private JPanel mainPanel;
    private JLabel titleLb;

    // CONSTRUCTOR
    public PropertyCardSmallView(PropertyCard card) {
        super();

        mainPanel.setBackground(card.getColor());
        titleLb.setText(card.getName());
        if (card.getColor() == Colors.CHARCOAL)
            titleLb.setForeground(Colors.WHITE);
    }

    // METHODS
    JPanel getContent() {
        return mainPanel;
    }
}
