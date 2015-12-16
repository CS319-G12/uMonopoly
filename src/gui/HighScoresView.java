package gui;

import models.HighScores;
import models.token.TokenFigure;

import javax.swing.*;

/**
 * @author anikristo
 */
public class HighScoresView {

    // ATTRIBUTES
    private JPanel mainPn;
    private JLabel dateLb;
    private JLabel nameLb;
    private JLabel tokenLb;
    private JLabel scoreLb;

    // CONSTRUCTOR
    public HighScoresView(int rank, HighScores hs) {
        dateLb.setText(hs.getDate());
        nameLb.setText(String.format("%d.   %s  ", rank, hs.getName()));
        tokenLb.setIcon(TokenFigure.getTokenFigure(hs.getTokenFigure()).getSmallIcon());
        scoreLb.setText(String.format("     %s $", hs.getAmount()));

        mainPn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    // METHODS
    public JPanel getContent() {
        return mainPn;
    }
}
