package gui;

import models.Game;
import models.squares.Square;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author anikristo
 */
public class MonopolyBoardView extends JPanel {

    // CONSTRUCTOR
    public MonopolyBoardView(Game game) { // TODO check
        List<Square> squares = game.getListOfSquares();

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(730, 730));
        this.setMinimumSize(new Dimension(730, 730));
        this.setMaximumSize(new Dimension(730, 730));

        add(new BottomBoardPanel(squares.subList(0, 11)), BorderLayout.SOUTH);
        add(new LeftBoardPanel(squares.subList(11, 20)), BorderLayout.WEST);
        add(new TopBoardPanel(squares.subList(20, 31)), BorderLayout.NORTH);
        add(new RightBoardPanel(squares.subList(31, 40)), BorderLayout.EAST);
        add(new CenterBoardPanel(game).getContent(), BorderLayout.CENTER);

    }
}
