package domain.token;

/**
 * @author Ali Gocer
 */
public class Token {

    // ATTRIBUTES
    private int position;
    private TokenType type;
    private TokenFigure figure;

    // CONSTRUCTOR
    public Token(TokenFigure figure) {
        position = 0;
        type = TokenType.SIMPLE;
        this.figure = figure;
    }


    // METHODS
    public TokenType getType() {
        return type;
    }

    public TokenFigure getFigure() {
        return figure;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int pos) {
        this.position = pos;
    }

}
