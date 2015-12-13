package gui;

import models.token.TokenFigure;

import javax.swing.*;

/**
 * @author anikristo
 */
public abstract class SquareView extends JPanel {

    // METHODS
    public abstract void addTokenFigure(TokenFigure figure) throws SquareFullException;

    public abstract void removeTokenFigure(TokenFigure figure) throws InvalidTokenRemovalException;

    // ATTRIBUTES
    public enum Rotation {
        LEFT, TOP, RIGHT, BOTTOM
    }

    // INNER CLASSES
    class SquareFullException extends Exception {

    }

    class InvalidTokenRemovalException extends Exception {
    }

    class InvalidHouseRemovalException extends Exception {

    }
}
