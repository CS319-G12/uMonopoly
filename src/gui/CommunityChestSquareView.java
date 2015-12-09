package gui;

import models.squares.CommunityChestCardSquare;
import models.squares.SquareType;
import models.token.TokenFigure;

import javax.swing.*;

/**
 * @author anikristo
 */
public class CommunityChestSquareView implements SquareView {

    // ATTRIBUTES
    private JPanel mainPanel;
    private JLabel titleLb;
    private JLabel iconLb;

    private JLabel firstTokenLb;
    private JLabel secondTokenLb;
    private JLabel thirdTokenLb;
    private JLabel fourthTokenLb;

    // CONSTRUCTOR
    public CommunityChestSquareView(CommunityChestCardSquare square) {
        titleLb.setText(square.getName());
        iconLb.setIcon(square.getSquareType() == SquareType.ELECTRIC_COMPANY
                ? new ImageIcon(getClass().getResource("/img/electric_company_small.png"))
                : new ImageIcon(getClass().getResource("/img/water_works_small.png")));
    }

    // METHODS
    public JPanel getContent() {
        return mainPanel;
    }

    public void addTokenFigure(TokenFigure figure) throws SquareFullException {
        if (firstTokenLb.getIcon() == null)
            firstTokenLb.setIcon(figure.getIcon());
        else if (secondTokenLb.getIcon() == null)
            secondTokenLb.setIcon(figure.getIcon());
        else if (thirdTokenLb.getIcon() == null)
            thirdTokenLb.setIcon(figure.getIcon());
        else if (fourthTokenLb.getIcon() == null)
            fourthTokenLb.setIcon(figure.getIcon());
        else
            throw new SquareFullException();
    }

    public void removeTokenFigure(TokenFigure figure) throws InvalidTokenRemovalException {
        if (firstTokenLb.getIcon() != null)
            firstTokenLb.setIcon(null);
        else if (secondTokenLb.getIcon() != null)
            secondTokenLb.setIcon(null);
        else if (thirdTokenLb.getIcon() != null)
            thirdTokenLb.setIcon(null);
        else if (fourthTokenLb.getIcon() != null)
            fourthTokenLb.setIcon(null);
        else
            throw new InvalidTokenRemovalException();
    }
}
