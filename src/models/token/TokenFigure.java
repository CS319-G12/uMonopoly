package models.token;

import javax.swing.*;

/**
 * @author Ali Gocer
 */
public enum TokenFigure {

    DOG("Dog", "/img/dog.png", "/img/dog_sel.png"),
    CAR("Car", "/img/car.png", "/img/car_sel.png"),
    HAT("Hat", "/img/hat.png", "/img/hat_sel.png"),
    THIMBLE("Thimble", "/img/thimble.png", "/img/thimble_sel.png"),
    SHOE("Shoe", "/img/shoe.png", "/img/shoe_sel.png"),
    IRON("Iron", "/img/iron.png", "/img/iron_sel.png");

    // PROPERTIES
    private final String name;
    private final ImageIcon icon;
    private final ImageIcon selectedIcon;

    // CONSTRUCTOR
    TokenFigure(String name, String pathToIcon, String pathToSelectedIcon) {
        this.name = name;
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

    public String getName() {
        return name;
    }

}
