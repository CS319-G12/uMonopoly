package models.token;

import javax.swing.*;

/**
 * @author Ali Gocer
 */
public enum TokenFigure {

    DOG("Dog", "/img/dog.png", "/img/dog_sel.png", "/img/dog_small.png"),
    CAR("Car", "/img/car.png", "/img/car_sel.png", "/img/car_small.png"),
    HAT("Hat", "/img/hat.png", "/img/hat_sel.png", "/img/hat_small.png"),
    THIMBLE("Thimble", "/img/thimble.png", "/img/thimble_sel.png", "/img/thimble_small.png"),
    SHOE("Shoe", "/img/shoe.png", "/img/shoe_sel.png", "/img/shoe_small.png"),
    IRON("Iron", "/img/iron.png", "/img/iron_sel.png", "/img/iron_small.png");

    // PROPERTIES
    private final String name;
    private final ImageIcon icon;
    private final ImageIcon selectedIcon;
    private final ImageIcon smallIcon;

    // CONSTRUCTOR
    TokenFigure(String name, String pathToIcon, String pathToSelectedIcon, String pathToSmallIcon) {
        this.name = name;
        icon = new ImageIcon(getClass().getResource(pathToIcon));
        selectedIcon = new ImageIcon(getClass().getResource(pathToSelectedIcon));
        smallIcon = new ImageIcon(getClass().getResource(pathToSmallIcon));
    }

    public static TokenFigure getTokenFigure(String tokenFigure) {
        switch (tokenFigure.toLowerCase()) {
            case "dog":
                return DOG;
            case "car":
                return CAR;
            case "thimble":
                return THIMBLE;
            case "hat":
                return HAT;
            case "shoe":
                return SHOE;
            case "iron":
                return IRON;
            default:
                return DOG;
        }
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

    public Icon getSmallIcon() {
        return smallIcon;
    }
}
