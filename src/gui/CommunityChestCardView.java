package gui;

import models.cards.CommunityChestCard;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * @author anikristo
 */
public class CommunityChestCardView {

    // ATTRIBUTES
    private JPanel mainPanel;
    private JTextPane descPane;

    // CONSTRUCTOR
    public CommunityChestCardView(CommunityChestCard card) {
        StyledDocument doc = descPane.getStyledDocument();
        MutableAttributeSet centerAttributeSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerAttributeSet, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), centerAttributeSet, false);

        descPane.setText(card.getDescription());
    }

    // METHODS
    public JPanel getContent() {
        return mainPanel;
    }
}
