package gui;

import models.squares.Square;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ani Kristo
 */
class CornerSquareView extends SquareView {

    private ImageIcon icon;

    // CONSTRUCTOR
    public CornerSquareView(Square s, ImageIcon icon) {
        super(s);

        this.icon = icon;

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
        add(tokenPn1, BorderLayout.EAST);
        add(tokenPn2, BorderLayout.SOUTH);
    }

    // METHODS
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.drawImage(icon.getImage(), 0, 0, null);
    }
}
