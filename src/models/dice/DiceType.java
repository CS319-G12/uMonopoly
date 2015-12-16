package models.dice;

/**
 * @author Ali Gocer
 */
public enum DiceType {
    GOLDEN("GOLDEN"), PLATINUM("PLATINUM"), SIMPLE("");

    // ATTRIBUTES
    private String name;

    // CONSTRUCTOR
    DiceType(String name) {
        this.name = name;
    }

    // METHODS
    @Override
    public String toString() {
        return name;
    }
}
