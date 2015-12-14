package gui;

import models.squares.RailroadsSquare;
import models.token.TokenFigure;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ani Kristo
 */
public class RRailroadsSquareView extends SquareView {
    private JLabel firstTokenLb;
    private JLabel secondTokenLb;
    private JLabel thirdTokenLb;
    private JLabel fourthTokenLb;

    // CONSTRUCTOR
    public RRailroadsSquareView(RailroadsSquare square) {
        // Token labels
        firstTokenLb = new JLabel();
        secondTokenLb = new JLabel();
        thirdTokenLb = new JLabel();
        fourthTokenLb = new JLabel();

        // Token panel
        JPanel tokenPn = new JPanel(new GridLayout(2, 2, 0, 0));
        tokenPn.setMinimumSize(new Dimension(60, 60));
        tokenPn.setMaximumSize(new Dimension(60, 60));
        tokenPn.setPreferredSize(new Dimension(60, 60));
        tokenPn.setOpaque(false);
        tokenPn.add(firstTokenLb);
        tokenPn.add(secondTokenLb);
        tokenPn.add(thirdTokenLb);
        tokenPn.add(fourthTokenLb);

        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(95, 60));
        setMaximumSize(new Dimension(95, 60));
        setPreferredSize(new Dimension(95, 60));
        add(tokenPn, BorderLayout.CENTER);
    }


    // METHODS
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

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.drawImage(new ImageIcon(getClass().getResource("/img/railroads_r.png")).getImage(), 0, 0, null);
    }
}
