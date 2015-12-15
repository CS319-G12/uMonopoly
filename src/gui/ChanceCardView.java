package gui;

import models.cards.ChanceCard;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * @author Ani Kristo
 */
public class ChanceCardView {

    // ATTRIBUTES
    private JPanel mainPanel;
    private JTextPane descPane;

    // CONSTRUCTOR
    public ChanceCardView(ChanceCard card) {
        // Centering the horizontal text alignment
        StyledDocument doc = descPane.getStyledDocument();
        MutableAttributeSet centerAttributeSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerAttributeSet, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), centerAttributeSet, false);

        descPane.setText(card.getDescription());

        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    // METHODS
    public JPanel getContent() {
        return mainPanel;
    }
}
