package models.cards;

import javax.swing.*;

/**
 * @author buseburcu
 */


public abstract class BonusCard {

    // CONSTANT UNIQUE ID
    private static int id_count = 0;

    // PROPERTIES
    private final int id;
    private final int amount;
    private final boolean jail;
    private final boolean outOfJail;
    private final String desc;

    // CONSTRUCTOR
    BonusCard(int amount, boolean jail, boolean outOfJail, String desc) {
        this.id = id_count++;
        this.amount = amount;
        this.jail = jail;
        this.outOfJail = outOfJail;
        this.desc = desc;
    }

    // METHODS
    public int getPayAmount() {
        return amount;
    }

    public int getID() {
        return id;
    }

    public boolean isJailCard() {
        return jail;
    }

    public boolean isOutOfJailCard() {
        return outOfJail;
    }

    public String getDescription() {
        return desc;
    }

    public abstract JPanel getView();
}
