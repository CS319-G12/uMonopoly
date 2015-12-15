package gui;

import models.cards.PropertyCard;

import javax.swing.*;

/**
 * @author Ani Kristo
 */
class PropertyCardSmallView {

    // ATTRIBUTES
    private JPanel mainPanel;
    private JLabel titleLb;

    private java.awt.Color backgroundColor;
    private java.awt.Color foregroundColor;

    // CONSTRUCTOR
    public PropertyCardSmallView(PropertyCard card) {
        super();

        backgroundColor = card.getColor().awtColor();
        mainPanel.setBackground(backgroundColor);
        titleLb.setText(String.format("<html><center><div style=\"width:%dpx;\">%s</div></center></html>", 60, card.getName()));
        foregroundColor = java.awt.Color.BLACK;
        if (card.getColor() == Color.CHARCOAL)
            foregroundColor = java.awt.Color.WHITE;
        titleLb.setForeground(foregroundColor);
    }

    // METHODS
    JPanel getContent() {
        return mainPanel;
    }

    public void setEnabled(boolean enabled) {
        if (!enabled) {
            mainPanel.setBackground(Color.DISABLED.awtColor());
            titleLb.setForeground(java.awt.Color.WHITE);
        } else {
            mainPanel.setBackground(backgroundColor);
            titleLb.setForeground(foregroundColor);
        }
    }
}
