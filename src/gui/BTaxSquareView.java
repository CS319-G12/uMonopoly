package gui;

import models.squares.TaxSquare;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ani Kristo
 */
public class BTaxSquareView extends SquareView {

    // CONSTRUCTOR
    public BTaxSquareView(TaxSquare square) {
        super(square);

        // Token panel
        JPanel tokenPn = new JPanel(new GridLayout(2, 2, 0, 0));
        tokenPn.setMinimumSize(new Dimension(60, 60));
        tokenPn.setMaximumSize(new Dimension(60, 60));
        tokenPn.setPreferredSize(new Dimension(60, 60));
        tokenPn.setBackground(Color.BACKGROUND.awtColor());
        tokenPn.add(firstTokenLb);
        tokenPn.add(secondTokenLb);
        tokenPn.add(thirdTokenLb);
        tokenPn.add(fourthTokenLb);

        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(60, 95));
        setMaximumSize(new Dimension(60, 95));
        setPreferredSize(new Dimension(60, 95));
        add(tokenPn, BorderLayout.CENTER);
    }
}
