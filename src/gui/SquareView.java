package gui;

import models.token.TokenFigure;

import javax.swing.*;
import java.awt.*;

/**
 * @author anikristo
 */
public abstract class SquareView extends JPanel {

    private Rotation rotation;

    // CONSTRUCTOR
    public SquareView(Rotation rotation) {
        this.rotation = rotation;
    }

    // METHODS
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);


        // Perform rotation
        Graphics2D g2 = (Graphics2D) graphics;
        switch (rotation) {
            case LEFT:
                g2.rotate(Math.toRadians(90));
            case TOP:
                g2.rotate(Math.toRadians(180));
            case RIGHT:
                g2.rotate(Math.toRadians(270));
        }
    }

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
}
