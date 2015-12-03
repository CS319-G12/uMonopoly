package gui;

import domain.token.TokenFigure;

/**
 * @author anikristo
 */
public interface SquareView {
    void addTokenFigure(TokenFigure figure) throws SquareFullException;

    void removeTokenFigure(TokenFigure figure) throws InvalidTokenRemovalException;

    // INNER CLASSES
    class SquareFullException extends Exception {

    }

    class InvalidTokenRemovalException extends Exception {
    }
}
