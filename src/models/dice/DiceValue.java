package models.dice;

import javax.swing.*;

/**
 * @author Ani Kristo
 */
public enum DiceValue {

    // FACES
    ONE("One", 1, "/img/dice1.png"),
    TWO("Two", 2, "/img/dice2.png"),
    THREE("Three", 3, "/img/dice3.png"),
    FOUR("Four", 4, "/img/dice4.png"),
    FIVE("Five", 5, "/img/dice5.png"),
    SIX("Six", 6, "/img/dice6.png");

    // ATTRIBUTES
    private final ImageIcon icon;
    private final int value;
    private final String name;

    // CONSTRUCTOR
    DiceValue(String name, int value, String pathToIcon) {
        this.name = name;
        this.value = value;
        this.icon = new ImageIcon(getClass().getResource(pathToIcon));
    }

    // METHODS
    public ImageIcon getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public boolean equals(DiceValue other) {
        return other.value == this.value;
    }
}
