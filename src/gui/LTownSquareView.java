package gui;

import models.squares.TownSquare;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ani Kristo
 */
public class LTownSquareView extends TownSquareView {

    // CONSTRUCTOR
    public LTownSquareView(TownSquare square) {
        super(square);

        // Color panel
        JPanel colorPn = new JPanel(new GridLayout(4, 1, 0, 0));
        colorPn.setMinimumSize(new Dimension(24, 60));
        colorPn.setMaximumSize(new Dimension(24, 60));
        colorPn.setPreferredSize(new Dimension(24, 60));
        colorPn.setBackground(square.getColor().awtColor());
        colorPn.add(firstHouseLb);
        colorPn.add(secondHouseLb);
        colorPn.add(thirdHouseLb);
        colorPn.add(fourthHouseLb);

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
        setMinimumSize(new Dimension(95, 60));
        setMaximumSize(new Dimension(95, 60));
        setPreferredSize(new Dimension(95, 60));
        add(colorPn, BorderLayout.EAST);
        add(tokenPn, BorderLayout.CENTER);

    }
}
