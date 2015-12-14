package gui;

import models.token.TokenFigure;

import javax.swing.*;

/**
 * @author Ani Kristo
 */
public abstract class SquareView extends JPanel {

    // METHODS
    public SquareView() {
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK.awtColor()));
    }

    public abstract void addTokenFigure(TokenFigure figure) throws SquareFullException;

    public abstract void removeTokenFigure(TokenFigure figure) throws InvalidTokenRemovalException;

    // INNER CLASSES
    class SquareFullException extends Exception {

    }

    class InvalidTokenRemovalException extends Exception {
    }

    class InvalidHouseRemovalException extends Exception {

    }
}
