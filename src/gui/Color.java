package gui;

/**
 * @author anikristo
 */
public enum Color {

    WHITE(0xffffff),
    BLACK(0x000000),
    BACKGROUND(0xcde6d0),
    BROWN(0x955436),
    LIGHT_BLUE(0xaae0fa),
    PINK(0xd93a96),
    ORANGE(0xf7941d),
    RED(0xed1b24),
    YELLOW(0xfef200),
    GREEN(0x1fb25a),
    BLUE(0x0072bb),
    MAROON(0xc1272d),
    CYAN(0x29abe2);

    // ATTRIBUTES
    private java.awt.Color color;

    // CONSTRUCTOR
    Color(int hex) {
        this.color = new java.awt.Color(hex);
    }

    // METHODS

}
