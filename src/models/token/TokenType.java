package models.token;

/**
 * @author Ali Gocer
 */
public enum TokenType {
    GOLDEN("GOLDEN"), PLATINUM("PLATINUM"), SIMPLE("");

    // ATTRIBUTES
    private String name;

    // CONSTRUCTOR
    TokenType(String name) {
        this.name = name;
    }

    // METHODS
    @Override
    public String toString() {
        return name;
    }
}
