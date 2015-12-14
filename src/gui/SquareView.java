package gui;

import models.Player;
import models.squares.Square;
import models.token.TokenFigure;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Ani Kristo
 */
abstract class SquareView extends JPanel implements Observer {

    // ATTRIBUTES
    final JLabel firstTokenLb;
    final JLabel secondTokenLb;
    final JLabel thirdTokenLb;
    final JLabel fourthTokenLb;

    // METHODS
    SquareView() {
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK.awtColor()));

        firstTokenLb = new JLabel();
        firstTokenLb.setMinimumSize(new Dimension(30, 30));
        firstTokenLb.setMaximumSize(new Dimension(30, 30));
        firstTokenLb.setPreferredSize(new Dimension(30, 30));

        secondTokenLb = new JLabel();
        secondTokenLb.setMinimumSize(new Dimension(30, 30));
        secondTokenLb.setMaximumSize(new Dimension(30, 30));
        secondTokenLb.setPreferredSize(new Dimension(30, 30));

        thirdTokenLb = new JLabel();
        thirdTokenLb.setMinimumSize(new Dimension(30, 30));
        thirdTokenLb.setMaximumSize(new Dimension(30, 30));
        thirdTokenLb.setPreferredSize(new Dimension(30, 30));

        fourthTokenLb = new JLabel();
        fourthTokenLb.setMinimumSize(new Dimension(30, 30));
        fourthTokenLb.setMaximumSize(new Dimension(30, 30));
        fourthTokenLb.setPreferredSize(new Dimension(30, 30));
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof Square) {
            removeAllTokens();
            Square s = (Square) observable;
            for (Player p : s.getResidingPlayers())
                addTokenFigure(p.getTokenFigure());
        }
    }

    final void addTokenFigure(TokenFigure figure) {
        if (firstTokenLb.getIcon() == null)
            firstTokenLb.setIcon(figure.getIcon());
        else if (secondTokenLb.getIcon() == null)
            secondTokenLb.setIcon(figure.getIcon());
        else if (thirdTokenLb.getIcon() == null)
            thirdTokenLb.setIcon(figure.getIcon());
        else if (fourthTokenLb.getIcon() == null)
            fourthTokenLb.setIcon(figure.getIcon());
    }

    private final void removeAllTokens() {
        firstTokenLb.setIcon(null);
        secondTokenLb.setIcon(null);
        thirdTokenLb.setIcon(null);
        fourthTokenLb.setIcon(null);
    }

    // INNER CLASSES
    class InvalidHouseRemovalException extends Exception {

    }
}
