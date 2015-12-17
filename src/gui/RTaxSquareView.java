package gui;

import models.squares.TaxSquare;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ani Kristo
 */
class RTaxSquareView extends SquareView {

    // CONSTRUCTOR
    public RTaxSquareView(TaxSquare square) {
        super(square);

        // Title
        JLabel title = new JLabel(String.format("<html><center>%s<br>(%d$)</center></html>",
                square.getName(), square.getTaxAmount()));
        title.setBackground(Color.BACKGROUND.awtColor());
        title.setOpaque(true);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 10));

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
        add(tokenPn, BorderLayout.CENTER);
        add(title, BorderLayout.NORTH);
    }
}
