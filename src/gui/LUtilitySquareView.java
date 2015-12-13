package gui;

import models.squares.UtilitySquare;
import models.token.TokenFigure;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ani Kristo
 */
public class LUtilitySquareView extends SquareView {

    // ATTRIBUTES
    private JPanel mainPanel;
    private JLabel titleLb;
    private JLabel firstTokenLb;
    private JLabel secondTokenLb;
    private JLabel thirdTokenLb;
    private JLabel fourthTokenLb;

    // CONSTRUCTOR
    public LUtilitySquareView(UtilitySquare square) {
        titleLb.setText(square.getName());
        add(mainPanel);
    }


    // METHODS
    public void addTokenFigure(TokenFigure figure) throws SquareView.SquareFullException {
        if (firstTokenLb.getIcon() == null)
            firstTokenLb.setIcon(figure.getIcon());
        else if (secondTokenLb.getIcon() == null)
            secondTokenLb.setIcon(figure.getIcon());
        else if (thirdTokenLb.getIcon() == null)
            thirdTokenLb.setIcon(figure.getIcon());
        else if (fourthTokenLb.getIcon() == null)
            fourthTokenLb.setIcon(figure.getIcon());
        else
            throw new SquareView.SquareFullException();
    }

    public void removeTokenFigure(TokenFigure figure) throws SquareView.InvalidTokenRemovalException {
        if (firstTokenLb.getIcon() != null)
            firstTokenLb.setIcon(null);
        else if (secondTokenLb.getIcon() != null)
            secondTokenLb.setIcon(null);
        else if (thirdTokenLb.getIcon() != null)
            thirdTokenLb.setIcon(null);
        else if (fourthTokenLb.getIcon() != null)
            fourthTokenLb.setIcon(null);
        else
            throw new SquareView.InvalidTokenRemovalException();
    }

    @Override
    public void paintComponents(Graphics graphics) {
        super.paintComponents(graphics);

        graphics.drawImage(new ImageIcon(getClass().getResource("/img/electric_company_l.png")).getImage(), 0, 0, null);
    }
}
