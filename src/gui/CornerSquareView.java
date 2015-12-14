package gui;

import models.token.TokenFigure;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ani Kristo
 */
public class CornerSquareView extends SquareView {

    private JLabel firstTokenLb;
    private JLabel secondTokenLb;
    private JLabel thirdTokenLb;
    private JLabel fourthTokenLb;

    private ImageIcon icon;

    // CONSTRUCTOR
    public CornerSquareView(ImageIcon icon) {
        this.icon = icon;

        // Token labels
        firstTokenLb = new JLabel();
        secondTokenLb = new JLabel();
        thirdTokenLb = new JLabel();
        fourthTokenLb = new JLabel();

        // Token panel
        JPanel tokenPn1 = new JPanel(new GridLayout(2, 1, 0, 0));
        tokenPn1.setMinimumSize(new Dimension(60, 30));
        tokenPn1.setMaximumSize(new Dimension(60, 30));
        tokenPn1.setPreferredSize(new Dimension(60, 30));
        tokenPn1.setOpaque(false);
        tokenPn1.add(firstTokenLb);
        tokenPn1.add(secondTokenLb);

        JPanel tokenPn2 = new JPanel(new GridLayout(1, 2, 0, 0));
        tokenPn2.setMinimumSize(new Dimension(30, 60));
        tokenPn2.setMaximumSize(new Dimension(30, 60));
        tokenPn2.setPreferredSize(new Dimension(30, 60));
        tokenPn2.setOpaque(false);
        tokenPn2.add(thirdTokenLb);
        tokenPn2.add(fourthTokenLb);

        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(95, 95));
        setMaximumSize(new Dimension(95, 95));
        setPreferredSize(new Dimension(95, 95));
        add(tokenPn1, BorderLayout.WEST);
        add(tokenPn2, BorderLayout.SOUTH);
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

        graphics.drawImage(icon.getImage(), 0, 0, null);
    }
}
