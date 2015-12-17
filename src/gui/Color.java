package gui;

/**
 * @author Ani Kristo
 */
public enum Color {

    BLACK(0x000000),
    CHARCOAL(0x555555),
    BACKGROUND(0xcde6d0),
    BROWN(0x955436),
    LIGHT_BLUE(0xaae0fa),
    PINK(0xd93a96),
    ORANGE(0xf7941d),
    RED(0xed1b24),
    YELLOW(0xfef200),
    GREEN(0x1fb25a),
    BLUE(0x0072bb),
    DISABLED(0xcccccc);

    // ATTRIBUTES
    private final java.awt.Color color;

    // CONSTRUCTOR
    Color(int hex) {
        this.color = new java.awt.Color(hex);
    }

    // METHODS
    public java.awt.Color awtColor() {
        return color;
    }

}
