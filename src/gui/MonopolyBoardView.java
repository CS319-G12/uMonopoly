package gui;

import models.Game;
import models.squares.Square;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Ani Kristo
 */
class MonopolyBoardView extends JPanel {

    // CONSTRUCTOR
    public MonopolyBoardView(Game game) {
        List<Square> squares = game.getListOfSquares();

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(755, 750));
        this.setMinimumSize(new Dimension(750, 750));
        this.setMaximumSize(new Dimension(750, 750));

        add(new BottomBoardPanel(squares.subList(0, 11)), BorderLayout.SOUTH);
        add(new LeftBoardPanel(squares.subList(11, 20)), BorderLayout.WEST);
        add(new TopBoardPanel(squares.subList(20, 31)), BorderLayout.NORTH);
        add(new RightBoardPanel(squares.subList(31, 40)), BorderLayout.EAST);
        add(new CenterBoardPanel(game).getContent(), BorderLayout.CENTER);

        setMaximumSize(new Dimension(752, 752));
        setMinimumSize(new Dimension(752, 752));
        setPreferredSize(new Dimension(752, 752));
    }
}
