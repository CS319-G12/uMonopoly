package domain.token;

import javax.swing.*;

/**
 * @author Ali Gocer
 */
public enum TokenFigure {

    DOG("/img/dog.png", "/img/dog_sel.png"),
    CAR("/img/car.png", "/img/car_sel.png"),
    HAT("/img/hat.png", "/img/hat_sel.png"),
    THIMBLE("/img/thimble.png", "/img/thimble_sel.png"),
    SHOE("/img/shoe.png", "/img/shoe_sel.png"),
    IRON("/img/iron.png", "/img/iron_sel.png");

    // PROPERTIES
    private final ImageIcon icon;
    private final ImageIcon selectedIcon;

    // CONSTRUCTOR
    TokenFigure(String pathToIcon, String pathToSelectedIcon) {
        icon = new ImageIcon(getClass().getResource(pathToIcon));
        selectedIcon = new ImageIcon(getClass().getResource(pathToSelectedIcon));
    }

    // METHODS
    public ImageIcon getIcon() {
        return icon;
    }

    public ImageIcon getSelectedIcon() {
        return selectedIcon;
    }

}
