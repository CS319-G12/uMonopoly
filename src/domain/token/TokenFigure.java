package domain.token;

import javax.swing.*;

/**
 * @author Ali Gocer
 */
public enum TokenFigure {

    DOG("/img/dog.png"), CAR("/img/car.png"), HAT("/img/hat.png"), THIMBLE("/img/thimble.png"),
    SHOE("/img/shoe.png"), IRON("/img/iron.png");

    // PROPERTIES
    private final ImageIcon icon;

    // CONSTRUCTOR
    TokenFigure(String path) {
        icon = new ImageIcon(getClass().getResource(path));
    }

    // METHODS
    public ImageIcon getIcon() {
        return icon;
    }

}
