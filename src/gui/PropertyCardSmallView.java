package gui;

import models.cards.PropertyCard;

import javax.swing.*;

/**
 * @author Ani Kristo
 */
class PropertyCardSmallView { // TODO test

    // ATTRIBUTES
    private JPanel mainPanel;
    private JLabel titleLb;

    private java.awt.Color color;

    // CONSTRUCTOR
    public PropertyCardSmallView(PropertyCard card) {
        super();

        color = card.getColor().awtColor();
        mainPanel.setBackground(color);
        titleLb.setText(String.format("<html><center><div style=\"width:%dpx;\">%s</div></center></html>", 60, card.getName()));
        if (card.getColor() == Color.CHARCOAL)
            titleLb.setForeground(java.awt.Color.WHITE);
    }

    // METHODS
    JPanel getContent() {
        return mainPanel;
    }

    public void setEnabled(boolean enabled) {
        if (!enabled)
            mainPanel.setBackground(Color.DISABLED.awtColor());
        else
            mainPanel.setBackground(color);
        titleLb.setEnabled(enabled);
    }
}
