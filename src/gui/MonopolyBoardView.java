package gui;

import models.Game;
import models.squares.Square;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Ani Kristo
 */
class MonopolyBoardView extends JPanel implements Observer {

    // CONSTRUCTOR
    public MonopolyBoardView(Game game) { // TODO check
        List<Square> squares = game.getListOfSquares();
        game.addObserver(this);

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(755, 750));
        this.setMinimumSize(new Dimension(750, 750));
        this.setMaximumSize(new Dimension(750, 750));

        add(new BottomBoardPanel(squares.subList(0, 11)), BorderLayout.SOUTH);
        add(new LeftBoardPanel(squares.subList(11, 20)), BorderLayout.WEST);
        add(new TopBoardPanel(squares.subList(20, 31)), BorderLayout.NORTH);
        add(new RightBoardPanel(squares.subList(31, 40)), BorderLayout.EAST);
        add(new CenterBoardPanel(game).getContent(), BorderLayout.CENTER);

    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof Game) {

            // TODO
            // Update the token views

            // Update the Card View

            // If Bonus Card Square, display randomly chosen card
        }
    }
}
