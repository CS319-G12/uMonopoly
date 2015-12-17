package gui;

import models.squares.UtilitySquare;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ani Kristo
 */
class LUtilitySquareView extends SquareView {

    // CONSTRUCTOR
    public LUtilitySquareView(UtilitySquare square) {
        super(square);

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
        setOpaque(false);
    }


    // METHODS
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponents(graphics);

        graphics.drawImage(new ImageIcon(getClass().getResource("/img/electric_company_l.png")).getImage(), 0, 0, null);
    }
}
