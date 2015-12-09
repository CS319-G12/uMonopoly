package gui;

import models.cards.PropertyCard;

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

        mainPanel.setBackground(card.getColor().awtColor());
        titleLb.setText(card.getName());
        if (card.getColor() == Color.CHARCOAL)
            titleLb.setForeground(java.awt.Color.WHITE);
    }

    // METHODS
    JPanel getContent() {
        return mainPanel;
    }
}
